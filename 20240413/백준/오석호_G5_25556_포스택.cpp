#include <iostream>
#include <stack>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(NULL);

	// 25556 포스택
	// 스택
	int n, input;
	stack<int> s[4];
	cin >> n;
	
	bool chk = false;
	for (int i = 0; i < n; ++i) {
		cin >> input;
		bool chk2 = false;
		// 비어있으면 빈곳에 넣기
		for (int j = 0; j < 4; ++j) {
			if (s[j].empty()) {
				s[j].push(input);
				chk2 = true;
				break;
			}
			else {
				if (s[j].top() < input) {
					s[j].push(input);
					chk2 = true;
					break;
				}
			}
		}
		if (!chk2) {
			chk = true;
			break;
		}
	}

	// 못넣었으면 No, 다넣었으면 Yes
	if (chk) cout << "NO";
	else cout << "YES";

	return 0;
}
