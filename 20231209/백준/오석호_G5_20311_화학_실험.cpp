#include <iostream>
#include <queue>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 20311 화학 실험
	// 우선순위큐, 그리디
	int n, k;
	int arr[300001] = { 0 };
	int ans[300001] = { 0 };
	priority_queue<pair<int, int>> pq; // 남은 시험관 수, 시험관 배열 번호
	cin >> n >> k;
	for (int i = 0; i < k; ++i) {
		cin >> arr[i];
		pq.push(make_pair(arr[i], i + 1));
	}

	// 만약 한가지 색상이 너무 많으면 불가능해지므로 -1 (제일 많은 색이 (n+1) / 2보다 많은 경우)
	if (pq.top().first > (n + 1) / 2) cout << -1;
	else {
		// 그게 아니면 pq에서 하나씩 뽑아서 리스트에 넣어보기
		// 대신 이전 요소는 빼놓고 있다가 다음 요소가 들어갔을 때 pq에 다시 넣어주기
		pair<int, int> cache;
		for (int i = 0; i < n; ++i) {
			pair<int, int> target;
			target = pq.top(); // 새친구 영입
			pq.pop(); // pq에서 이번에 넣을거 삭제
			--target.first; // 이번에 넣을 색깔의 시험관 개수 1개 줄이기
			ans[i] = target.second; // ans 배열에 값 넣기
			if (i && cache.first) pq.push(cache); // 캐시된거 다시 돌려놓기
			cache = target; // 캐시 갱신
		}
		for (int i = 0; i < n; ++i) cout << ans[i] << " ";
	}

	return 0;
}
