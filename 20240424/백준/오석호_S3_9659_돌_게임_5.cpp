#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(NULL);

	// 9659 돌 게임 5
	// 수학
	long long n;
	cin >> n;
	// 홀수면 상근이가, 짝수면 창영이가 이긴다
	if (n % 2) cout << "SK";
	else cout << "CY";

	return 0;
}
