#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 4158 CD
	// 구현
	while (1) {
		int n, m;
		int arr1[1000001] = { 0 };
		int arr2[1000001] = { 0 };
		int ans = 0;
		cin >> n >> m;
		if (n == 0 && m == 0) break;
		for (int i = 0; i < n; ++i) cin >> arr1[i];
		for (int i = 0; i < m; ++i) cin >> arr2[i];

		// 하나씩 증가하면서 체크
		int nIdx = 0;
		int mIdx = 0;
		while (1) {
			if (nIdx == n || mIdx == m) break;

			if (arr1[nIdx] == arr2[mIdx]) {
				++ans;
				++nIdx;
				++mIdx;
			}
			else if (arr1[nIdx] < arr2[mIdx]) ++nIdx;
			else if (arr1[nIdx] > arr2[mIdx]) ++mIdx;
		}
		cout << ans << '\n';
	}

	return 0;
}
