#include <iostream>
using namespace std;

int clockNum(int n) {
	int minValue = n;
	for (int i = 0; i < 3; ++i) {
		// 1121을 1211로 돌리는 방법
		// 1121 % 1000 * 10 + 1121 / 1000
		n = (n % 1000) * 10 + (n / 1000);
		if (minValue > n) minValue = n;
	}
	return minValue;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 2659 십자카드 문제
	// 구현, 시뮬레이션
	int n1, n2, n3, n4;
	int target;
	int ans = 1;
	cin >> n1 >> n2 >> n3 >> n4;
	target = n1 * 1000 + n2 * 100 + n3 * 10 + n4;

	// 주어진 입력에 대한 시계수 처리
	target = clockNum(target);

	// 몇 번째 시계수인지 찾기
	for (int i = 1111; i < target; ++i) {
		if (clockNum(i) == i) ++ans;
	}
	cout << ans;

	return 0;
}
