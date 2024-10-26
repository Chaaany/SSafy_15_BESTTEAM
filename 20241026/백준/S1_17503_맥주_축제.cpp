#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 17503 맥주 축제
	// 그리디
	int n, m, k, v, c; // v 10만, k,n 20만, m c는 2^31 
	vector<pair<int, int>> vv;
	priority_queue<int, vector<int>, greater<int>> pq; // 선호도를 오름차순으로 저장
	cin >> n >> m >> k;

	for (int i = 0; i < k; ++i) {
		cin >> v >> c;
		vv.push_back(make_pair(c, v));
	}
	sort(vv.begin(), vv.end()); // 도수를 오름차순으로 정렬

	int sum = 0; // 선호도의 합을 저장한다 (얘가 m보다 커야함)

	// 마실 수 있는 모든 맥주 도수 순으로 후루룩 (마실 수 있는 모든 맥주의 선호도를 pq를 통해 정렬)
	for (int i = 0; i < k; ++i) {
		pq.push(vv[i].second); 
		sum += vv[i].second; 

		// 맥주 더 마셨다면 선호도가 가장 낮은 맥주 제거
		if (pq.size() > n) {
			sum -= pq.top();
			pq.pop();
		}

		// 맥주 다마셨고 선호도의 합이 충족되면 끝
		if (pq.size() == n && sum >= m) {
			cout << vv[i].first;
			return 0;
		}
	}

	cout << -1;

	return 0;
}
