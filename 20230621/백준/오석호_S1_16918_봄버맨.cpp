#include <iostream>
#include <string>
using namespace std;

string arr[201];
string tmp[201];
int dr[4] = { 0,1,0,-1 };
int dc[4] = { -1,0,1,0 };

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 16918 봄버맨
	// 구현
	int r, c, n;
	cin >> r >> c >> n;
	for (int i = 0; i < r; ++i) cin >> arr[i];

	// n이 짝수면 전부 O
	if (n % 2 == 0) {
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) cout << 'O';
			cout << "\n";
		}
		return 0;
	}
	// 초기화
	else for (int j = 0; j < r; ++j) tmp[j] = arr[j];

	for (int i = 1; i < n; i += 2) {
		// 다시 초기화
		for (int j = 0; j < r; ++j) tmp[j] = arr[j];

		// 복사배열에서 BFS
		for (int j = 0; j < r; ++j) {
			for (int k = 0; k < c; ++k) {
				if (arr[j][k] == 'O') {
					for (int l = 0; l < 4; ++l) {
						int rr = j + dr[l];
						int cc = k + dc[l];
						if (rr >= 0 && rr < r && cc >= 0 && cc < c) tmp[rr][cc] = 'O';
					}
				}
			}
		}

		// 원본배열에 적용
		for (int j = 0; j < r; ++j) {
			for (int k = 0; k < c; ++k) {
				if (tmp[j][k] == 'O') arr[j][k] = '.';
				else arr[j][k] = 'O';
			}
		}
	}

	// 출력
	for (int i = 0; i < r; ++i) cout << arr[i] << '\n';

	return 0;
}
