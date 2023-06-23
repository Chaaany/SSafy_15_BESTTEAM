#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 20500 Ezreal 여눈부터 가네 ㅈㅈ
	// dp
	int n;
	cin >> n;

	// dp[i][j] 는 자리수가 i면서 각 자리수의 합을 3으로 나눈 나머지가 j인 수의 개수
	// 어짜피 1자리는 15의 약수가 없으므로 생략
	// 일의자리는 반드시 5
	// 1 아님 5가 뒤에 올 자리수니까 이것만 확인하면 됨
	// 1 5 15(0) 55(1) 115(1) 155(2) 515(2) 555(0)
	int dp[1516][3] = { 0 };
	dp[2][0] = 1;
	dp[2][1] = 1;
	dp[2][2] = 0;

	for (int i = 3; i <= n; ++i) {
		dp[i][0] = (dp[i - 1][1] + dp[i - 1][2]) % 1000000007;
		dp[i][1] = (dp[i - 1][2] + dp[i - 1][0]) % 1000000007;
		dp[i][2] = (dp[i - 1][1] + dp[i - 1][0]) % 1000000007;
	}

	cout << dp[n][0];

	return 0;
}
