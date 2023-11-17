#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 2217 로프
	// 그리디
	int n;
	int ans = 0;
	int rope[100001] = { 0 };
	cin >> n;
	for (int i = 0; i < n; ++i) cin >> rope[i];
	sort(rope, rope + n); // 정렬
	for (int i = 0; i < n; ++i) ans = max(ans, (n - i) * rope[i]); // 부하 중량 * 로프 수를 n번 반복하면서 ans값 처리
	cout << ans;

	return 0;
}
