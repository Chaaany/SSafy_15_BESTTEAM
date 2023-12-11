#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 4097 수익
	// DP, 그리디, 투포인터
	int n, input;
	cin >> n;
	while (n) {
		int maxValue = -10001;
		int tmp = 0;
		while(n--) {
			cin >> input;
			// 양수면 무조건 잇는게 베스트
			// 음수면 기존에 이어오고있는 구간 vs 현재 구간 중에서 더 이익이 큰게 베스트
			if (tmp + input > input) tmp = tmp + input;
			else tmp = input;
			maxValue = max(tmp, maxValue);
		}
		cout << maxValue << '\n';
		cin >> n;
	}

	return 0;
}
