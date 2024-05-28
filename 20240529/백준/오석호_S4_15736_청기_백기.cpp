#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 15736 청기 백기
	// 정수론
	int n;
	cin >> n;
	int ans = 0;

	// 약수가 홀수 -> 제곱수의 개수
	for (int i = 1; i * i <= n; ++i) ++ans;

	cout << ans;

	return 0;
}
