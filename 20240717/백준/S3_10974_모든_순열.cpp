#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 10974 모든 순열
	// 순열, 브루트포스
	int n;
	cin >> n;

	int arr[8] = { 0 };
	for (int i = 0; i < n; ++i)arr[i] = i + 1;
	
	// 초기값 출력
	for (int i = 0; i < n; ++i) cout << arr[i] << " ";
	cout << '\n';

	// 순열
	while (next_permutation(arr, arr + n)) {
		for (int i = 0; i < n; ++i) cout << arr[i] << " ";
		cout << '\n';
	}

	return 0;
}
