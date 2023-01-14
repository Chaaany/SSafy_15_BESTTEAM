#include <iostream>
#include <string>
using namespace std;

bool chk[2500][2500]; // s부터 e까지 팰린드롬인지 여부
int dp[2500]; // dp배열

bool isPalindrome(string str, int s, int e) {
	if (str[s] == str[e]) {
		// s와 e의 차이가 1이하이거나 내부가 팰린드롬이면 true
		if (e - s <= 1 || chk[s+1][e-1]) {
			chk[s][e] = true;
			return true;
		}
	}
	return false;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1509 팰린드롬 분할
	// DP
	string s;
	dp[0] = 1; // 1글자면 어짜피 팰린드롬일테니
	cin >> s;
	// ex) aabccbaa = 3
	for (int i = 1; i < s.size(); ++i) {
		dp[i] = dp[i - 1] + 1;
		for (int j = 0; j <= i; ++j) {
			if (isPalindrome(s, j, i)) {
				if (j == 0) dp[i] = 1;
				else dp[i] = min(dp[i], dp[j - 1] + 1);
			}
		}
	}

	cout << dp[s.size()-1];

	return 0;
}
