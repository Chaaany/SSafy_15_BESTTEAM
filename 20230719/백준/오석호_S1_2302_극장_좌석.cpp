#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 2302 극장 좌석
	// dp
	int n, m;
	int dp[41]; // 어짜피 좌석은 40개까지니까
	int vip[41];
	cin >> n >> m;
	for (int i = 0; i < m; ++i) cin >> vip[i];
	
	// dp 원리 - vip 사이에 좌석이 1개있을 때 "1" , 2개 있을때 1 2 / 2 1 "2", 3개 있을 때 1 2 3 / 1 3 2 / 2 1 3 "3", 4개 있을 때 1 2 3 4 / 2 1 3 4 / 1 3 2 4 / 1 2 4 3 / 2 1 4 3 "5"
	// 5개 있을 때 1 2 3 4 5 / 2 1 3 4 5 / 1 3 2 4 5 / 1 2 4 3 5 / 1 2 3 5 4 / 2 1 4 3 5 / 2 1 3 5 4 / 1 3 2 4 3 "8"
	// 1, 1, 2, 3, 5, 8 ... 피보나치다 (0개 있을 때도 1이라고 생각 - 좌석이 0인 경우는 없으니까)
	dp[0] = 1;
	dp[1] = 1;
	dp[2] = 2;
	for (int i = 3; i <= 40; ++i) dp[i] = dp[i - 1] + dp[i - 2];

	// vip 사이 좌석 개수를 확인하고 좌석 배치 수 곱해주기
	int tmp = 0;
	int ans = 1;
	for (int i = 0; i < m; ++i) {
		if (vip[i] - tmp != 1) ans *= dp[vip[i] - tmp - 1];
		tmp = vip[i];
	}
	if (n - tmp != 0) ans *= dp[n - tmp]; // 마무리

	cout << ans;

	return 0;
}
