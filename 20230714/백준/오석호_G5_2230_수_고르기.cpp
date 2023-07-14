#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 2230 수 고르기
	// 정렬, 브루트포스
	int n, m;
	int arr[100001] = { 0 };
	int ans = 2000000001;
	cin >> n >> m;
	for (int i = 0; i < n; ++i) cin >> arr[i];
	// 찾기 편하게 하려고 정렬
	sort(arr, arr + n);
	for (int i = 0; i < n; ++i) {
		// arr[i]+m 보다 같거나 큰 숫자가 언제 등장하는지 체크
		auto idx = lower_bound(arr, arr + n, arr[i] + m);
		// 못찾아서 arr+n이 나오는게 아니라면 최소값으로 ans를 갱신
		if (idx != arr + n) ans = min(ans, abs(arr[i] - *idx));
	}
	cout << ans;

	return 0;
}
