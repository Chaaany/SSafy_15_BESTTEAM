#include <iostream>
#include <algorithm>
using namespace std;

int n;
char arr[51][51];
int ans = 0;

void chk() {
	// 가로 체크
	for (int i = 0; i < n; ++i) {
		int tmp = 1;
		for (int j = 0; j < n - 1; ++j) {
			if (arr[i][j] == arr[i][j + 1]) {
				++tmp;
				ans = max(ans, tmp);
			}
			else {
				ans = max(ans, tmp);
				tmp = 1;
			}
		}
	}

	// 세로 체크
	for (int j = 0; j < n; ++j) {
		int tmp = 1;
		for (int i = 0; i < n - 1; ++i) {
			if (arr[i][j] == arr[i + 1][j]) {
				++tmp;
				ans = max(ans, tmp);
			}
			else {
				ans = max(ans, tmp);
				tmp = 1;
			}
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 3085 사탕 게임
	// 브루트포스
	cin >> n;

	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			cin >> arr[i][j];
		}
	}

	// 기본상태에서 확인
	chk();

	// 가로 바꾸기
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n - 1; ++j) {
			if (arr[i][j] != arr[i][j + 1]) {
				// 변경
				swap(arr[i][j], arr[i][j + 1]);
				// 확인
				chk();
				// 복구
				swap(arr[i][j], arr[i][j + 1]);
			}
		}
	}

	// 세로 바꾸기
	for (int i = 0; i < n - 1; ++i) {
		for (int j = 0; j < n; ++j) {
			if (arr[i][j] != arr[i + 1][j]) {
				swap(arr[i + 1][j], arr[i][j]);
				chk();
				swap(arr[i + 1][j], arr[i][j]);
			}
		}
	}

	cout << ans;

	return 0;
}
