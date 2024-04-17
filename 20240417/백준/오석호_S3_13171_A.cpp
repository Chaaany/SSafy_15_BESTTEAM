#include <iostream>
using namespace std;

long long exp(long long a, long long b) {
	if (!b) return 1;

	long long tmp = exp(a, b / 2); // 반씩 쪼개기 (로그번으로 단축)
	if (!(b % 2)) return (tmp % 1000000007 * tmp % 1000000007) % 1000000007;
	else return ((tmp % 1000000007 * tmp % 1000000007) * a % 1000000007) % 1000000007; // 마지막 남는거 따로 곱해주기
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(NULL);

	// 13171 A
	// 재귀, 분할정복
	long long a, x;
	cin >> a >> x;
	cout << exp(a % 1000000007, x); // 연산자 우선순위 이슈 (*랑 %는 우선순위가 같음)

	return 0;
}
