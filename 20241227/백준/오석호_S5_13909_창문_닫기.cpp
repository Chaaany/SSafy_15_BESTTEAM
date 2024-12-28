#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 13909 창문 닫기
	// 수학
	int n;
	int ans = 0;
	cin >> n;

	for (int i = 1; i * i <= n; ++i) ++ans;
	cout << ans;

	return 0;
}
