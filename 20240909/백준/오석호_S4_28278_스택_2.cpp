#include <iostream>
#include <stack>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 28278 스택 2
	// 스택
	int n, m, input;
	stack<int> s;
	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> m;
		if (m == 1) {
			cin >> input;
			s.push(input);
		}
		else if (m == 2) {
			if (!s.empty()) {
				cout << s.top() << '\n';
				s.pop();
			}
			else cout << "-1" << '\n';
		}
		else if (m == 3) cout << s.size() << '\n';
		else if (m == 4) {
			if (s.empty()) cout << "1" << '\n';
			else cout << "0" << '\n';
		}
		else if (m == 5) {
			if (!s.empty()) cout << s.top() << '\n';
			else cout << "-1" << '\n';
		}
	}

	return 0;
}
