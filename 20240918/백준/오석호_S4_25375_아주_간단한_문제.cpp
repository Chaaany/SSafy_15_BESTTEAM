#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 25375 아주 간단한 문제
	// 정수론
	long long a, b, q;
	cin >> q;
	for (long long i = 0; i < q; ++i) {
		cin >> a >> b;

		// 조건 1
		// x, y의 최대공약수는 a
		// x와 y는 모두 a의 배수로 생각할 수 있음
		
		// 조건 2
		// x + y는 b
		// 조건 1에 의해  x + y = ? * a + ?? * a = ??? * a = b 형태로 변경 가능 (b는 a의 배수)
		// 그리고 a와 b는 양의 정수이므로 a < b는 확실 (a != 0, b != 0)

		// 즉, a < b이면서 b % a == 0이면 쌍이 존재한다고 볼 수 있음
		if (a < b && b % a == 0) cout << 1 << '\n';
		else cout << 0 << '\n';
	}

	return 0;
}
