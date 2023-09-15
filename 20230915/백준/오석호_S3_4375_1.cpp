#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 4375 1
	// 브루트포스
	int n;
	while (cin >> n) {
		int tmp = 0;
		for (int i = 1; i <= n; ++i) {
			// 1 붙여가면서 나누어 떨어지는지 무한으로 확인
			tmp = tmp * 10 + 1;
			tmp %= n;
			if (tmp == 0) {
				cout << i << '\n';
				break;
			}
		}
	}

	return 0;
}
