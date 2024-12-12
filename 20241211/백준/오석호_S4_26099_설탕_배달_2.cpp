#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 26099 설탕 배달 2
	// 그리디
	long long n;
	long long ans = 0;
	cin >> n;

	// 5로 나누어 떨어질 때까지 3kg 봉지 가져가기
	while (n % 5) {
		n -= 3;
		++ans;
		if (n < 0) break;
	}

	if (n < 0) cout << -1;
	else cout << ans + n / 5;

	return 0;
}
