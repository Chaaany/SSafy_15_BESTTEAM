#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1644 소수의 연속합
	// 투포인터
	int n;
	bool chk[4000001] = { 0 };
	vector<int> prime;

	cin >> n;
	for (int i = 2; i <= sqrt(n); ++i) {
		for (int j = 2 * i; j <= n; j += i) {
			chk[j] = true;
		}
	}
	
	for (int i = 2; i <= n; ++i) {
		if (!chk[i]) prime.push_back(i);
	}

	int s = 0;
	int e = 0;
	int sum = 0;
	int ans = 0;
	while (1) {
		if (sum > n) {
			sum -= prime[s];
			++s;
		}
		else if (sum < n) {
			if (e >= prime.size()) break;
			sum += prime[e];
			++e;
		}
		else {
			++ans;
			if (e >= prime.size()) break;
			sum += prime[e] - prime[s];
			++e;
			++s;
		}
	}

	cout << ans;
	
	return 0;
}
