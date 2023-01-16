#include <iostream>
#include <algorithm>
#include <string>
#include <cmath>
using namespace std;

int alpha[26];
bool chk[26];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1339 단어 수학
	// 수학
	int n;
	int ans = 0;
	int cnt = 9;
	string s;
	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> s;
		reverse(s.begin(), s.end());
		for (int j = 0; j < s.size(); ++j) alpha[s[j] - 65] += pow(10, j);
	}
	while (1) {
		int maxValue = 0;
		int maxIdx = -1;
		for (int i = 0; i < 26; ++i) {
			if (!chk[i] && maxValue < alpha[i]) {
				maxValue = alpha[i];
				maxIdx = i;
			}
		}
		if (maxValue == 0) break;

		chk[maxIdx] = true;
		ans += alpha[maxIdx] * cnt;
		--cnt;
	}

	cout << ans;

	return 0;
}
