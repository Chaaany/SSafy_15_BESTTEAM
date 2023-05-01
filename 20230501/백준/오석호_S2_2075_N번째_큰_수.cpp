#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 2075 N번째 큰 수
	// 구현
	int arr[2250001] = { 0 }; // 1500^2 = 2250000
	int n;
	cin >> n;
	for (int i = 0; i < n * n; ++i) cin >> arr[i];
	sort(arr, arr + n * n);
	cout << arr[n * n - n];

	return 0;
}
