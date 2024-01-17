#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 2847 게임을 만든 동준이
	// 그리디
	int n;
	int arr[101] = { 0 };
	int ans = 0;
	cin >> n;
	
	for (int i = 0; i < n; ++i) cin >> arr[i];

	// 뒤에서부터 체크
	for (int i = n - 1; i > 0; --i) {
		while (arr[i] <= arr[i - 1]) {
			--arr[i - 1];
			++ans;
		}
	}

	cout << ans;

	return 0;
}
