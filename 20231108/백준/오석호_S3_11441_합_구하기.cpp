#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 11441 합 구하기
	// 누적합
	int n, a, m, ii, jj;
	int arr[100001] = { 0 };
	cin >> n;
	
	int sum = 0;
	for (int i = 0; i < n; ++i) {
		cin >> a;
		sum += a;
		arr[i + 1] = sum;
	}
	
	cin >> m;
	for (int i = 0; i < m; ++i) {
		cin >> ii >> jj;
		cout << arr[jj] - arr[ii - 1] << '\n';
	}

	return 0;
}
