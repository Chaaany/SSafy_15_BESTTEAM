#include <iostream>
#include <cmath>
using namespace std;

bool isPrime(int n) {
	if (n == 0 or n == 1) return false;
	for (int i = 2; i < n; i++) {
		if (n % i == 0) return false;
	}

	return true;
}

long long ncr(int n, int r) {
	long long a = 1;
	long long b = 1;

	// nCr 돌리기
	for (int i = n; i > n - r; --i) {
		a *= i;
		b *= (n - i + 1);
	}
	
	return a / b;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1344 축구
	// 조합, 확률
	double a, b;
	cin >> a >> b;
	a /= 100;
	b /= 100;

	double sumA = 0;
	double sumB = 0;

	for (int i = 0; i < 19; ++i) {
		if (isPrime(i)) {
			sumA += (double)ncr(18, i) * pow(a, i) * pow(1 - a, 18 - i);
			sumB += (double)ncr(18, i) * pow(b, i) * pow(1 - b, 18 - i);
		}
	}

	cout << sumA + sumB - sumA * sumB;

	return 0;
}
