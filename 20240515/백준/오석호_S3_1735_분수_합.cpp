#include <iostream>
using namespace std;

int gcd(int a, int b) {
	if (!b) return a;
	return gcd(b, a % b);
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1735 분수 합
	// 수학, 정수론
	int a1, b1, a2, b2, a3, b3;
	cin >> a1 >> b1 >> a2 >> b2;
	a3 = a1 * b2 + a2 * b1;
	b3 = b1 * b2;

	int g = gcd(a3, b3);
	
	cout << a3 / g << " " << b3 / g;

	return 0;
}
