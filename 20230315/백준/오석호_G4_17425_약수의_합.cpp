#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 17425 약수의 합
	// dp
	long long dp[1000001] = { 0 };
	int t, n;

	// 1부터 1000000까지 dp에 계속 더해주기
	for (int i = 1; i <= 1000000; ++i) {
		for (int j = i; j <= 1000000; j += i) dp[j] += i;
	}
	
	// x보다 작거나 같은 모든 자연수 y의 f(y)값 더해주기
	for (int i = 2; i <= 1000000; ++i) dp[i] += dp[i - 1];

	cin >> t;

	for (int i = 0; i < t; ++i) {
		cin >> n;
		cout << dp[n] << '\n';
	}

	return 0;
}
