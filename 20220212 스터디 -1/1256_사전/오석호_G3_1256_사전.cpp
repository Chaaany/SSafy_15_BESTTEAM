#include <iostream>
#include <string>
using namespace std;

int n, m, k, cnt;
bool fin = false;

int comb(long long a, long long b) {
	long long ret = 1;
	if (b > a - b) b = a - b;
	for (long long i = 1; i <= b; ++i) {
		ret *= a - i + 1;
		ret /= i;
		if (ret >= k) {
			ret = 1000000000;
			break;
		}
	}

	return (int)ret;
}

void recur(string str, long long a, long long b) {
	if (fin) return;
	if (cnt + comb(a + b, b) < k) {
		cnt += comb(a + b, b);
		return;
	}

	if (a == 0 && b == 0) {
		cout << str;
		fin = true;
		return;
	}

	if (a > 0) recur(str + "a", a - 1, b);
	if (b > 0) recur(str + "z", a, b - 1);
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	// 1256 사전
	// 조합
	// 2 2  -> aazz azaz azza zaaz zaza zzaa

	cin >> n >> m >> k;
	recur("", n, m);

	if (!fin) cout << -1;
	
	return 0;
}
