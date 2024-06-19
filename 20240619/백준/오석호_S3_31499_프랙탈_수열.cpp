#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 31499 프랙탈 수열
	// 수학
	int n, m;
	cin >> n >> m;

	long long ans = 1;
	for (int i = 1; i <= n; ++i) ans = (ans * i) % m;

	cout << ans;

	return 0;
}
