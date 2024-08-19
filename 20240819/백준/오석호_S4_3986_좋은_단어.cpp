#include <iostream>
#include <string>
#include <stack>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 3986 좋은 단어
	// 스택
	int n;
	string s;
	int ans = 0;
	cin >> n;

	while (n--) {
		stack<char> st;
		cin >> s;
		for (int i = 0; i < s.size(); ++i) {
			// 스택이 비었으면 그냥 넣고 내부에 뭐가 있으면 top이랑 비교해서 넣거나 빼는거 결정
			if (!st.size()) st.push(s[i]);
			else {
				if (st.top() != s[i]) st.push(s[i]);
				else st.pop();
			}
		}
		// 마지막에 stack이 비었다면 좋은 단어
		if (st.empty()) ++ans;
	}

	// 출력
	cout << ans;

	return 0;
}
