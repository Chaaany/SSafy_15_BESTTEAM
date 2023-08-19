#include <iostream>
#include <cmath>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 2879 코딩은 예쁘게
	// 그리디
	int n, tmp;
	int arr[1001] = { 0 };
	int ans = 0;
	cin >> n;

	for (int i = 0; i < n; ++i) cin >> arr[i];
	for (int i = 0; i < n; ++i) {
		cin >> tmp;
		arr[i] -= tmp;
	}

	int saved = 0;
	if (n > 1) {
		saved = arr[0];
		for (int i = 1; i < n; ++i) {
			if (saved * arr[i] < 0) ans += abs(saved);
			else if (abs(saved) >= abs(arr[i])) ans += abs(saved - arr[i]);
			saved = arr[i];
		}
	}
	else ans = arr[0];
	ans += abs(saved);
	cout << ans;

	return 0;
}
