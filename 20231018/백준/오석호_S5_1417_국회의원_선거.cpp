#include <iostream>
#include <queue>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1417 국회의원 선거
	// 우선순위큐
	int n, target, m;
	int ans = 0;
	priority_queue<int> pq;
	cin >> n >> target;

	for (int i = 1; i < n; ++i) {
		cin >> m;
		pq.push(m);
	}

	if (pq.empty()) cout << 0;
	else {
		while (pq.top() >= target) {
			int tmp = pq.top();
			pq.pop();
			++target;
			++ans;
			if (tmp != 1) pq.push(tmp - 1);
		}
		cout << ans;
	}

	return 0;
}
