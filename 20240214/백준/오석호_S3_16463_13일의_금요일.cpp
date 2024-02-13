#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 16463 13일의 금요일
	// 브루트포스
	int n;
	int month[12] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	int day = 0; // 2019.01.13은 일요일이므로 0이 일요일, 5가 금요일이라고 생각
	int ans = 0;

	cin >> n;

	for (int i = 2019; i <= n; ++i) {
		// 윤년체크
		if (i % 400 == 0 || (i % 4 == 0 && i % 100 != 0)) month[1] = 29;
		else month[1] = 28;

		// 화요일인지 체크
		for (int j = 0; j < 12; ++j) {
			if (day == 5) ++ans;
			day = (day + month[j]) % 7;
		}
	}
	cout << ans;

	return 0;
}
