#include <iostream>
using namespace std;

int n;

bool chk(int target) {
	for (int i = 2; i * i <= target; ++i) {
		if (!(target % i)) return false;
	}
	return true;
}

void backtrack(int num, int length) {
	if (length == n) {
		cout << num << '\n';
		return;
	}

	if (length == 0) {
		backtrack(2, 1);
		backtrack(3, 1);
		backtrack(5, 1);
		backtrack(7, 1);
		return;
	}

	for (int i = 1; i <= 9; ++i) {
		if (chk(num * 10 + i)) backtrack(num * 10 + i, length + 1);
	}

	return;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 2023 신기한 소수
	// 백트래킹
	cin >> n;
	backtrack(0, 0);

	return 0;
}
