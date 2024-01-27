#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 30648 트릭 플라워
	// 구현
	int a, b, r;
	bool chk[1001][1001] = { 0 };
	int ans = 1;
	cin >> a >> b >> r;

	// 최초 위치 체크
	chk[a][b] = true;

	while (1) {
		// 좌표이동
		if (a + b + 2 < r) {
			++a;
			++b;
		}
		else {
			a /= 2;
			b /= 2;
		}

		// 체크
		if (chk[a][b]) break;
		else {
			chk[a][b] = true;
			++ans;
		}
	}

	cout << ans;

	return 0;
}
