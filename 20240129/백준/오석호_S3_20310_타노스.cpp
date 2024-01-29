#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 20310 타노스
	// 문자열
	int zero = 0;
	int one = 0;
	bool chk[501] = { 0 };
	string s;
	string ans = "";
	cin >> s;

	for (int i = 0; i < s.size(); ++i) {
		if (s[i] == '0') ++zero;
		else ++one;
	}

	// 0은 뒤에서부터, 1은 앞에서부터 절반씩 쳐낸다
	int zcnt = 0;
	int ocnt = 0;

	for (int i = s.size() - 1; i >= 0; --i) {
		if (s[i] == '0') {
			chk[i] = true;
			++zcnt;
			if (zcnt == zero / 2) break;
		}
	}

	for (int i = 0; i < s.size(); ++i) {
		if (s[i] == '1') {
			chk[i] = true;
			++ocnt;
			if (ocnt == one / 2) break;
		}
	}

	for (int i = 0; i < s.size(); ++i) {
		if (!chk[i]) ans += s[i];
	}

	cout << ans;

	return 0;
}
