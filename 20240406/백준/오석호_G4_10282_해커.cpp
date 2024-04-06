#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(NULL);

	// 10282 해커
	// 다익스트라
	int t, n, d, c, a, b, s;
	int arr[10001] = { 0 }; // 각 배열에서 감염되는데 걸리는 최소시간을 가진 배열
	cin >> t;
	while (t--) {
		vector<pair<int, int>> v[10001]; // 감염되는데 걸리는 시간, 의존하는 컴퓨터 번호를 담은 벡터
		cin >> n >> d >> c;
		for (int i = 1; i <= n; ++i) arr[i] = 10000001;

		for (int i = 0; i < d; ++i) {
			cin >> a >> b >> s;
			v[b].push_back(make_pair(s, a)); // 시간, 감염되는 컴퓨터
		}

		priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

		arr[c] = 0; // 최초 감염된 컴퓨터 시간 처리
		pq.push(make_pair(arr[c], c)); // 시간, 타겟 컴퓨터 번호

		while (!pq.empty()) {
			pair<int, int> tmp = pq.top(); // 연결된 다른 컴퓨터를 감염시킬 수 있는 숙주 컴퓨터 선택
			pq.pop();
			if (arr[tmp.second] != tmp.first) continue;

			// 감염된 컴퓨터에 의해 새롭게 감염될 수 있는 의존성을 가진 컴퓨터 순회
			for (auto& target : v[tmp.second]) {
				// 이미 더 빠르게 감염된게 있으면 스킵
				if (arr[target.second] <= arr[tmp.second] + target.first) continue;
				arr[target.second] = arr[tmp.second] + target.first;
				pq.push(make_pair(arr[target.second], target.second));
			}
		}

		// 감염되는 컴퓨터 수와 감염되는데 가장 오래 걸리는 요소를 찾아서 출력
		int maxValue = 0;
		int cnt = 0;
		for (int i = 1; i <= n; ++i) {
			if (arr[i] != 10000001) {
				++cnt;
				maxValue = max(maxValue, arr[i]);
			}
		}
		cout << cnt << " " << maxValue << '\n';
	}

	return 0;
}
