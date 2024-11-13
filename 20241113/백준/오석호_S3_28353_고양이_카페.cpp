#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 28353 고양이 카페
	// 그리디, 투포인터
	int n, k;
	cin >> n >> k;
	int arr[5001] = { 0 };

	for (int i = 0; i < n; ++i) cin >> arr[i];

	// 무게순으로 정렬
	sort(arr, arr + n);

	int s = 0;
	int e = n - 1;
	int ans = 0;
	while (s < e) {
		// 두마리 무게 합이 k 이하라면 ++ans
		if (arr[s] + arr[e] <= k) {
			++ans;
			++s;
			--e;
		}
		// k보다 크다면 못 버티니까 무게 줄이기
		else --e; 
	}

	cout << ans;

	return 0;
}
