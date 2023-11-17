#include <iostream>
#include <string>
#include <stack>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 10799 쇠막대기
	// 스택
	string s;
	stack<int> st;
	int ans = 0;
	cin >> s;

	for (int i = 0; i < s.size(); ++i) {
		// 레이저가 위치한 경우 - (로 끝날 일은 없으므로 index error가 나올 가능성은 0이다
		if (s[i] == '(' && s[i + 1] == ')') {
			ans += st.size();
			++i;
		}
		// 쇠막대기가 추가되는 경우
		else if (s[i] == '(') st.push(i);
		// 쇠막대기가 끝나는 경우
		else {
			++ans;
			st.pop();
		}
	}
	cout << ans;

	return 0;
}
