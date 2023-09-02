#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

bool isPrime[1005000];

void getPrime() {
	for (int i = 2; i < 1005000; ++i) isPrime[i] = true;
	for (int i = 2; i < 1005000; ++i) {
		for (int j = 2; j * j <= i; ++j) {
			if (i % j == 0) {
				isPrime[i] = false;
				break;
			}
		}
	}
}

bool isPalin(int n) {
	string s = to_string(n);
	string s2 = to_string(n);
	reverse(s2.begin(), s2.end());
	if (!s.compare(s2)) return true;
	else return false;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1747 소수&팰린드롬
	// 수학
	int n;
	cin >> n;

	getPrime();

	for (int i = n; i < 1005000; ++i) {
		if (isPrime[i] && isPalin(i)) {
			cout << i;
			break;
		}
	}

	return 0;
}
