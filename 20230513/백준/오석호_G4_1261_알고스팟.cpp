#include <iostream>
#include <string>
#include <queue>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1261 알고스팟
	// BFS
	int m, n; // 가로 세로
	string s; // 입력값
	int arr[100][100] = { 0 }; // 벽
	int ans[100][100] = { 0 }; // BFS 값 저장용
	int dx[4] = { 1, 0 ,-1, 0 };
	int dy[4] = { 0, 1, 0, -1 };
	cin >> m >> n;
	for (int i = 0; i < n; ++i) {
		cin >> s;
		for (int j = 0; j < m; ++j) {
			arr[i][j] = s[j] - '0';
			ans[i][j] = 10001; // 모든 벽을 부쉈을 때 10000이므로
		}
	}
	queue<pair<int, int>> q; // 좌표담기
	q.push(make_pair(0, 0));
	ans[0][0] = 0; // 첨엔 바로 갈 수 있으니까
	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();
		// 상하좌우 길찾기
		for (int i = 0; i < 4; ++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < m && nx >= 0 && ny < n && ny >= 0) {
				if (ans[ny][nx] > ans[y][x] + arr[ny][nx]) {
					ans[ny][nx] = ans[y][x] + arr[ny][nx];
					q.push(make_pair(nx, ny));
				}
			}
		}
	}
	cout << ans[n - 1][m - 1];

	return 0;
}
