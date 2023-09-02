#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1464 뒤집기 3
	// 문자열, 그리디
	string s;
	cin >> s;

	// 사전순으로 앞서는 문자를 만나면 뒤로 보내기 (2번 뒤집으면 됨)
	for (int i = 0; i < s.size() - 1; ++i) {
		if (s[i] < s[i + 1]) {
			reverse(s.begin(), s.begin() + i + 1);
			reverse(s.begin(), s.begin() + i + 2);
		}
	}

	// 사전순으로 앞서는 문자를 뒤로 보냈으니 그걸 뒤집으면 가장 앞서는 문자열이 됨
	reverse(s.begin(), s.end());
	cout << s;

	return 0;
}
