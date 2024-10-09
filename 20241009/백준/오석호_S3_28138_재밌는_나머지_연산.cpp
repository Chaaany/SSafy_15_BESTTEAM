#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 28138 재밌는 나머지 연산
	// 정수론
	long long n, r;
	cin >> n >> r;
	n -= r; // r을 뺀게 m으로 나누어 떨어져야 하기 때문에

	// 모든 약수를 구하기 (나머지가 r이 되야하기 때문에 약수가 r보다는 커야함)
	long long ans = 0; // 모든 양의 정수 m의 합

	for (long long i = 1; i * i <= n; ++i) {
		if (n % i) continue; // 나누어 떨어지지 않으면 다음으로
		else {
			if (i > r) ans += i; // 나누어 떨어지면 r이랑 비교해서 r보다 크면 ans에 더하기
			if (n / i > r && (i != n / i)) ans += n / i; // 반대쪽도 확인 (제곱수는 한번만 더해야함!!)
		}
	}

	cout << ans;

	return 0;
}
