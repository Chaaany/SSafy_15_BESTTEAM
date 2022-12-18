#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1915 가장 큰 정사각형
	// DP
	int arr[1000][1000] = { 0 };
	int n, m;
	int maxValue = 0;
	string s;
	cin >> n >> m;

	// 배열 넣기
	for (int i = 0; i < n; ++i) {
		cin >> s;
		for (int j = 0; j < m; ++j) {
			arr[i][j] = s[j] - '0';
			if (maxValue < arr[i][j]) maxValue = arr[i][j];
		}
	}

	// dp처리
	// arr에 들어가는 요소들은 해당 요소를 기준으로 왼쪽 위 방향으로 만들어지는 정사각형의 최대 한 변의 길이
	// 왼쪽, 왼쪽위, 위 요소들의 최솟값 + 1이 현재 위치의 값이 된다
	// 어짜피 맨 윗줄, 맨 왼쪽줄은 안해도 됨 (0 아님 1은 이미 기본값으로 들어있으니)
	for (int i = 1; i < n; ++i) {
		for (int j = 1; j < m; ++j) {
			// 0이 아닐 때만 고려
			if (arr[i][j]) {
				arr[i][j] = min(min(arr[i][j - 1], arr[i - 1][j - 1]), arr[i - 1][j]) + 1;
				if (maxValue < arr[i][j]) maxValue = arr[i][j];
			}
		}
	}

	cout << maxValue * maxValue;

	return 0;
}
