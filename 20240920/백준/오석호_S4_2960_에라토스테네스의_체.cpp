#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	// 2960 에라토스테네스의 체
  // 수학
	int n, k;
	bool arr[1001] = { false };
	cin >> n >> k;

	int cnt = 0;
	int tmp = 0;
	for (int i = 2; i <= n; ++i) {
		if (arr[i] == false) {
			for (int j = i; j <= n; j += i) {
				if (arr[j] == false) {
					arr[j] = true;
					cnt++;
					tmp = j;
					if (cnt == k) {
						cout << tmp;
						return 0;
					}
				}
			}
		}
	}

	return 0;
}
