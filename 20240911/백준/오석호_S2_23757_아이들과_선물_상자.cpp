#include <iostream>
#include <queue>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 23757 아이들과 선물 상자
	// 우선순위큐
	int n, m, c;
	int arr[100001] = { 0 }; // 원하는 선물의 개수
	priority_queue<int> pq;
	cin >> n >> m;

	// 선물상자에 들어있는 선물의 개수 pq에 저장
	for (int i = 0; i < n; ++i) {
		cin >> c;
		pq.push(c);
	}

	// i번째 친구가 원하는 선물의 개수
	for (int i = 0; i < m; ++i) cin >> arr[i];

	// 현재 선물이 가장 많이 담겨있는 상자에서 원하는 만큼 선물 가져가기
	for (int i = 0; i < m; ++i) {
		int tmp = pq.top();
		pq.pop();

		// 가져갈 수 있으면 가져가기
		if (tmp >= arr[i]) {
			tmp -= arr[i];
			// 남았으면 다시 선물보따리에 넣기
			if (tmp > 0) pq.push(tmp);
		}
		else {
			// 못가져가면 끝
			cout << 0;
			return 0;
		}
	}

	// 다 잘 가져갔으면 1 출력
	cout << 1;

	return 0;
}
