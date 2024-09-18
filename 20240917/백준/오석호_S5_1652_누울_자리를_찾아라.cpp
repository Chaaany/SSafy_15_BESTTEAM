#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1652 누울 자리를 찾아라
	// 구현
	int n;
	char c;
	bool arr[101][101] = { 0 };
	cin >> n;

	// 입력
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			cin >> c;
			if (c == '.') arr[i][j] = true; // 갈 수 있으면 true
		}
	}

	int row = 0;
	int col = 0;

	// 가로 체크
	int streaks = 0; // 2칸 이상이 발생하는 케이스 체크용
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			if (arr[i][j]) ++streaks;
			else streaks = 0;

			if (streaks == 2) ++row;
		}
		streaks = 0;
	}

	// 세로 체크
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			if (arr[j][i]) ++streaks;
			else streaks = 0;

			if (streaks == 2) ++col;
		}
		streaks = 0;
	}

	cout << row << " " << col;

	return 0;
}
