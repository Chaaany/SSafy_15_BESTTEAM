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
		int tmp = 1;
		int ans = 1;

		while (1) {
			if (tmp % n) {
				tmp %= n;
				tmp = tmp * 10 + 1;
			}
			else break;
			++ans;
		}

		cout << ans << '\n';
	}

	return 0;
}
