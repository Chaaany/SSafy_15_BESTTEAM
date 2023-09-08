#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 14650 걷다보니 신천역 삼 (Small)
	// dp
	int n;
	int dp[10] = { 0 };
	cin >> n;

	// 각 자리의 합이 3의 배수여야함
	// 나머지가 0인 수에 0을 붙이거나, 1인 수에 1을 붙이거나, 2인 수에 2를 붙이면 3의 배수가 된다
	// 이 말은 이전 자리수의 dp의 값의 합이 다음 dp의 값이 된다는 말
	dp[2] = 2;
	for (int i = 3; i <= n; ++i) dp[i] = dp[i - 1] * 3;
	cout << dp[n];

	return 0;
}
