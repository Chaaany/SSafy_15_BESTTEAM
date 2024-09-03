#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 24389 2의 보수
	// 비트마스킹
	int n;
	cin >> n;
	int c = -n; // c는 n의 2의 보수 -> 자연수 n의 2의 보수는 -n
	int ans = 0;
	for (int i = 0; i < 32; ++i) {
		// 맨 끝 자리부터 한자리씩 비교한다
		if ((n & 1) != (c & 1)) ++ans;
		// 끝 자리 비교했으면 한칸씩 땡긴다
		n >>= 1;
		c >>= 1;
	}
	cout << ans;

	return 0;
}
