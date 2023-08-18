#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1500 최대 곱
	// 수학
	long long s, k;
	cin >> s >> k;
	long long share = s / k;
	long long remainder = s % k;
	long long ans = 1;
	// 가장 비슷한 숫자끼리 곱해야 최댓값을 구할 수 있다
	for (int i = 0; i < k; ++i) {
		if (remainder) {
			ans *= share + 1;
			--remainder;
		}
		else ans *= share;
	}
	cout << ans;
	
	return 0;
}
