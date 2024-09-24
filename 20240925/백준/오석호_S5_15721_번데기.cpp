#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 15721 번데기
	// 구현
	int a, t, target;
	cin >> a >> t >> target;

	int bbun = 0;
	int degi = 0;
	int repeat = 2;
	
	while (1) {
		// 뻔 데기 뻔 데기
		for (int i = 0; i < 4; ++i) {
			if (i % 2) ++degi;
			else ++bbun;

			if ((bbun == t && target == 0) || (degi == t && target == 1)) {
				cout << (bbun + degi - 1) % a;
				return 0;
			}
		}

		// 뻔 * repeat
		for (int i = 0; i < repeat; ++i) {
			++bbun;
			if (bbun == t && target == 0) {
				cout << (bbun + degi - 1) % a;
				return 0;
			}
		}

		// 데기 * repeat
		for (int i = 0; i < repeat; ++i) {
			++degi;
			if (degi == t && target == 1) {
				cout << (bbun + degi - 1) % a;
				return 0;
			}
		}

		// 한사이클 끝나면 repeat 1번씩 더 하기
		++repeat;
	}

	return 0;
}
