#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 25496 장신구 명장 임스
	// 정렬
	int p, n;
	int arr[1000] = { 0 };
	int ans = 0;
	cin >> p >> n;
	for (int i = 0; i < n; ++i) cin >> arr[i];
	sort(arr, arr + n);
	if (p >= 200) cout << 0;
	else {
		// 피로도 덜드는것부터 순서대로 더하기
		for (int i = 0; i < n; ++i) {
			p += arr[i];
			++ans;
			if (p >= 200) break;
		}
		cout << ans;
	}

	return 0;
}
