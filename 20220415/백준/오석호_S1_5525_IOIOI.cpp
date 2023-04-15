#include <iostream>
#include <string>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);	
	cout.tie(NULL);

	// 5525 IOIOI
	// 문자열
	int n, m;
	string s;
	cin >> n >> m >> s;
	int dp[1000001] = { 0 };
	int cnt = 0;
	for (int i = 1; i < m - 1; ++i) {
		if (s[i] == 'O' && s[i + 1] == 'I') {
			dp[i + 1] = dp[i - 1] + 1;
			if (dp[i + 1] >= n && s[i - 2 * n + 1] == 'I') ++cnt;
		}
	}
	cout << cnt;

	return 0;
}
