#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1748 수 이어 쓰기 1
	// 수학
	int n;
	cin >> n;
	long long ans = 0;
	// 자리수의 개수만큼 ans에 더해주기
	for (int i = 1; i <= n; i *= 10) ans += (long long)(n - i + 1);

	cout << ans;

	return 0;
}
