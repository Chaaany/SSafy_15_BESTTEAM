#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 2548 대표 자연수
	// 정렬
	int n;
	int arr[20001] = { 0 };
	cin >> n;
	for (int i = 0; i < n; ++i) cin >> arr[i];
	sort(arr, arr + n);

	if (n % 2) cout << arr[n / 2];
	else cout << arr[n / 2 - 1];

	return 0;
}
