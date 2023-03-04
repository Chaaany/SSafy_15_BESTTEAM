#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 17435 합성함수와 쿼리
	// DP
	int m, q, n, x;
	int arr[21][200001] = { 0 }; // log 500000 < 20임

	// 입력받기
	cin >> m;
	for (int i = 1; i <= m; ++i) cin >> arr[0][i];

	// 합성함수처리
	for (int i = 1; i <= 20; ++i) {
		for (int j = 0; j <= m; ++j) {
			arr[i][j] = arr[i - 1][arr[i - 1][j]];
		}
	}

	cin >> q;
	for (int i = 0; i < q; ++i) {
		cin >> n >> x;
		for (int j = 0; n != 0; ++j) {
			if (n & 1) x = arr[j][x];
			n = n >> 1;
		}
		cout << x << '\n';
	}
	
	return 0;
}
