#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);	
	cout.tie(NULL);

	// 12847 꿀 아르바이트
	// 누적합
	int m, n;
	int arr[100001] = { 0 };
	long long ans = 0;
	cin >> m >> n;
	for (int i = 0; i < m; ++i) cin >> arr[i];
	long long tmp = 0;
	for (int i = 0; i < m; ++i) {
		if (i >= n) tmp -= arr[i - n];
		tmp += arr[i];
		ans = max(ans, tmp);
	}
	cout << ans;

	return 0;
}
