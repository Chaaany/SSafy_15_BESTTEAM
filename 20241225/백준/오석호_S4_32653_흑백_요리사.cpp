#include <iostream>
using namespace std;

long long gcd(long long a, long long b) {
	while (b != 0) {
		int tmp = a % b;
		a = b;
		b = tmp;
	}
	return a;
}

long long lcm(long long a, long long b) {
	return a * b / gcd(a, b);
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 32653 흑백 요리사
	// 수학
	int n;
	long long input;
	long long ans = 1;
	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> input;
		ans = lcm(ans, input * 2); // 앞뒤를 모두 구워야하기 때문에 2를 곱해준다
	}

	cout << ans;

	return 0;
}
