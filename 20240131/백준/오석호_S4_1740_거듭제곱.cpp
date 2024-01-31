#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1740 거듭제곱
	// 비트마스킹
	long long n;
	cin >> n;

	// 3비트로 생각해서 풀기
	// 3진수가 0 혹은 1로만 구성되있을 때만 세야 한다
	// 그 개수는 이진수이므로 이진수를 삼진수로만 바꿔주면 된다
	// 4번째로 작은 서로 다른 3의 제곱수의 합으료 표현되는 수는 100(3), 즉 9이다
	// 5번째로 작은 서로 다른 3의 제곱수의 합으로 표현되는 수는 101(3), 즉 10이다

	// 한자리씩 땡겨가면서 확인하기
	long long ans = 0;
	long long tmp = 1;
	while (n) {
		if (n & 1) ans += tmp;
		tmp *= 3;
		n /= 2;
	}

	cout << ans;

	return 0;
}
