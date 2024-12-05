#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 2553 마지막 팩토리얼 수
	// 수학
	long long n;
	cin >> n;
	long long ans = 1;

	for (int i = 1; i <= n; ++i) {
		ans *= i;
		ans %= 1000000000; // 오버플로우 방지
		while (!(ans % 10)) ans /= 10;
	}

	cout << ans % 10;

	return 0;
}
