#include <iostream>
#include <algorithm>
using namespace std;

long long n, k; // 10^5 * 10^5 는 int로 표현이 안됨..

// mid보다 작거나 같은 수의 개수 구하기
long long chk(long long m) {
	long long cnt = 0;
	for (long long i = 1; i <= n; ++i) cnt += min(n, m / i);
	return cnt;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1300 K번째 수
	// 이분탐색
	cin >> n >> k;
	long long l = 1;
	long long r = n * n;
	long long ans = 0;

	while (l <= r) {
		long long m = (l + r) / 2;
		if (chk(m) < k) l = m + 1; // mid보다 작은 수의 개수가 더 작으면 left값 증가
		else {
			ans = m;
			r = m - 1; // mid보다 큰 수의 개수가 더 작으면 right값 감소 
		}
	}
	cout << ans;

	return 0;
}
