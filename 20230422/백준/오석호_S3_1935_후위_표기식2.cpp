#include <iostream>
#include <stack>
#include <string>
using namespace std;

stack<double> st;

void cal(char c) {
	double a = st.top();
	st.pop();
	double b = st.top();
	st.pop();
	if (c == '+') st.push(b + a);
	else if (c == '-') st.push(b - a);
	else if (c == '*') st.push(b * a);
	else if (c == '/') st.push(b / a);
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);	
	cout.tie(NULL);

	// 1935 후위 표기식2
	// 스택
	int alpha[26];
	int n;
	string s;
	
	cin >> n >> s;
	for (int i = 0; i < n; ++i) cin >> alpha[i];
	for (int i = 0; i < s.size(); ++i) {
		if (s[i] >= 65 && s[i] <= 90) st.push(alpha[s[i] - 65]);
		else cal(s[i]);
	}
	cout << fixed;
	cout.precision(2);
	cout << st.top();

	return 0;
}
