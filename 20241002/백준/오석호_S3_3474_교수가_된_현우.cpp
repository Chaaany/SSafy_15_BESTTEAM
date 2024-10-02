#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 3474 교수가 된 현우
	// 수학
	int t, n;
	cin >> t;
	while (t--) {
		cin >> n;
		int two = 0;
		int five = 0;

		// 2의 배수이면서 동시에 5의 배수이면 0이 있다
		// 10 = 2 * 5이므로 2로 나누어지는 횟수와 5로 나누어지는 횟수 중에서 작은 쪽을 출력해준다
		for (int i = 2; i <= n; i *= 2) two += n / i;
		for (int i = 5; i <= n; i *= 5) five += n / i;

		cout << min(two, five) << '\n';
	}
	
	return 0;
}
