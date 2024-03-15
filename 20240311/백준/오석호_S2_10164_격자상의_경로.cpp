#include <iostream>
using namespace std;

int path(int x, int y) {
	// 조합에서 (x+y)C(x) 를 구하면 된다
	// (x+y)! / x!y!
	// 근데 그냥 나누면 28!인데 이건 long long으로도 커버가 안되서 나누면서 처리해준다
	int move = x + y;
	long long ans = 1;
	int j = 1;
	for (int i = x + 1; i <= move; ++i) {
		ans *= i;
		// y!로도 나누어야 하니까 나눌 수 있을 때마다 계속 나눠서 자리수를 줄여준다
		while (j <= y && !(ans % j)) ans /= j++;
	}

	return ans;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 10164 격자상의 경로
	// 수학
	int n, m, k;
	cin >> n >> m >> k;
	if (k) --k;

	// k의 위치 (k가 0이면 0, 0이 들어감)
	int x1 = k / m;
	int y1 = k % m;

	// 최종 도착 위치
	int x2 = n - 1 - x1;
	int y2 = m - 1 - y1;

	// 연산
	cout << path(x1, y1) * path(x2, y2);

	return 0;
}
