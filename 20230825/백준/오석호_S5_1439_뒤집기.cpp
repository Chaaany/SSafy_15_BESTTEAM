#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1439 뒤집기
	// 문자열, 그리디
	string s;
	cin >> s;
	int one = 0;
	int zero = 0;
	for (int i = 0; i < s.size() - 1; ++i) {
		if (s[i] != s[i + 1]) {
			if (s[i] == '0') ++zero;
			else ++one;
		}
	}
	cout << min(zero, one);

	return 0;
}
