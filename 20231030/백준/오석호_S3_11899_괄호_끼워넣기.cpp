#include <iostream>
#include <string>
#include <stack>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 11899 괄호 끼워넣기
	// 스택
	string s;
	int ans = 0;
	stack<char> ss;

	cin >> s;

	for (int i = 0; i < s.size(); ++i) {
		if (s[i] == '(') ss.push('(');
		else {
			if (ss.empty()) ++ans;
			else ss.pop();
		}
	}

	// 추가해야만 했던거 + 스택에 남아있는거 개수 출력
	cout << ans + ss.size();

	return 0;
}
