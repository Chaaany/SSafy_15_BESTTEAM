#include <iostream>
#include <cmath>
using namespace std;

void recur(int n) {
	if (n == 0) {
		cout << "-";
		return;
	}

	// 선 공백 선 순서로 자르기
	recur(n - 1);
	for (int i = 0; i < pow(3, n - 1); ++i) cout << " ";
	recur(n - 1);
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 4779 칸토어 집합
	// 재귀
	int n;
	while (cin >> n) {
		recur(n);
		cout << '\n';
	}

	return 0;
}
