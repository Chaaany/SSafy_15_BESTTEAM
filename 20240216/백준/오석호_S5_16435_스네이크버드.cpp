#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 16435 스네이크버드
	// 그리디
	int n, l;
	int arr[1001] = { 0 };
	cin >> n >> l;
	for (int i = 0; i < n; ++i) cin >> arr[i];
	sort(arr, arr + n);
	for (int i = 0; i < n; ++i) if (arr[i] <= l) ++l;
	cout << l;

	return 0;
}
