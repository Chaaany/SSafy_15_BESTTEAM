#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1456 거의 소수
	// 수학, 정수론
	long long a, b;
	long long ans = 0;
	cin >> a >> b;

	// 10000000까지의 소수를 모두 구한다 (false면 소수)
	bool chk[10000001] = { 0 };
	for (int i = 2; i * i <= 10000000; ++i) {
		if (!chk[i]) {
			for (int j = i * i; j <= 10000000; j += i) chk[j] = true;
		}
	}

	// 그 소수들의 제곱수가 a와 b 사이에 포함되어있는지 여부를 센다
	for (long long i = 2; i * i <= b; ++i) {
		if (!chk[i]) {
			// 그 제곱수가 n제곱일 수도 있다.. 2가 아닐 수도 있잖아
			long long tmp = i;

			for (long long j = i * i; j <= b; j *= i) {
				if (j / i != tmp) continue;

				if (j >= a) ++ans;
				tmp = j;
			}
		}
	}

	cout << ans;

	return 0;
}
