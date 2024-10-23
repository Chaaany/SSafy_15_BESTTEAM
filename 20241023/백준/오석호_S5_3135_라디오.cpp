#include <iostream>
#include <cmath>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 3135 라디오
	// 정렬
	int a, b, n, input;
	int arr[5] = { 0 };
	cin >> a >> b >> n;
	for (int i = 0; i < n; ++i) {
		cin >> input;
		arr[i] = abs(input - b) + 1; // 저장된 곳으로 이동한 뒤에 b로 가는 횟수 저장
	}

	// 정렬
	sort(arr, arr + n);

	if (arr[0] < abs(a - b)) cout << arr[0];
	else cout << abs(a - b);

	return 0;
}
