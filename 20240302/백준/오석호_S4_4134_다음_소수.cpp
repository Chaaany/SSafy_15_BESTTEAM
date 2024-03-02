#include <iostream>
#include <cmath>
using namespace std;

bool isPrime(long long n) {
	if (n == 0 || n == 1) return false;

	for (int i = 2; i <= sqrt(n); ++i) {
		if (n % i == 0) return false;
	}

	return true;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 4134 다음 소수
	// 브루트포스
	long long t, n;
	cin >> t;
	while (t--) {
		cin >> n;
		while (1) {
			if (isPrime(n)) {
				cout << n << '\n';
				break;
			}
			else ++n;
		}
	}

	return 0;
}
