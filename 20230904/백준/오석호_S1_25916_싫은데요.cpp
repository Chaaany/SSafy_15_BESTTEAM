#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 25916 싫은데요
	// 투포인터
	int n, m;
	int arr[500001] = { 0 };
	cin >> n >> m;
	for (int i = 0; i < n; ++i) cin >> arr[i];

	int s = 0;
	int e = 0;
	int now = 0;
	int ans = 0;
	while (e < n) {
		if (now + arr[e] <= m) {
			now += arr[e];
			if (ans < now) ans = now;
			++e;
		}
		else {
			now -= arr[s];
			++s;
		}
	}
	cout << ans;

	return 0;
}
