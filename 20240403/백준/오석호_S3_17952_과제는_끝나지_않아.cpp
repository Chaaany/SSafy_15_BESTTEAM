#include <iostream>
#include <stack>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(NULL);

	// 17952 과제는 끝나지 않아!
	// 스택
	int n, a, t, input;
	stack<pair<int, int>> s;
	int ans = 0;
	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> input;
		// 새로운 과제가 있는 경우
		if (input) {
			cin >> a >> t;
			s.push(make_pair(a, t)); // 과제 점수, 걸리는 시간
		}
		// 시간의 흐름
		if (!s.empty()) {
			--s.top().second;
			if (!s.top().second) {
				ans += s.top().first;
				s.pop();
			}
		}
	}
	cout << ans;

	return 0;
}
