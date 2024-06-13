#include <iostream>
#include <queue>
#include <vector>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1781 컵라면
	// 우선순위큐
	int n, a, b;
	vector<int> v[200001];
	priority_queue<int, vector<int>, less<int>> pq;
	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> a >> b;
		v[a].push_back(b);
	}
	
	int ans = 0;

	// 역순으로 날짜를 줄여가며 가장 많은 컵라면을 얻는 경우의 수를 선택
	for (int i = n; i > 0; --i) {
		for (int j = 0; j < v[i].size(); ++j) pq.push(v[i][j]);
		if (!pq.empty()) {
			ans += pq.top();
			pq.pop();
		}
	}

	cout << ans;

	return 0;
}
