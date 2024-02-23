#include <iostream>
#include <string>
#include <queue>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 4179 불
	// BFS
	int r, c;
	queue<pair<int, int>> q1; // 불의 이동
	queue<pair<int, int>> q2; // 지훈이의 이동
	string maze[1001];
	int firetime[1001][1001] = { 0 };
	int movetime[1001][1001] = { 0 };

	int dx[4] = { 1, 0, -1, 0 };
	int dy[4] = { 0, 1, 0, -1 };

	cin >> r >> c;

	for (int i = 0; i < r; ++i) cin >> maze[i];

	// 못가는 곳 구분을 위해 -1 넣어두기
	for (int i = 0; i < r; ++i) {
		for (int j = 0; j < c; ++j) {
			firetime[i][j] = -1;
			movetime[i][j] = -1;
		}
	}

	// 시작점 체크
	for (int i = 0; i < r; ++i) {
		for (int j = 0; j < c; ++j) {
			// 불 시작점
			if (maze[i][j] == 'F') {
				q1.push(make_pair(i, j));
				firetime[i][j] = 0;
			}
			// 지훈이 시작점
			else if (maze[i][j] == 'J') {
				q2.push(make_pair(i, j));
				movetime[i][j] = 0;
			}
		}
	}

	// 불 이동시간 체크
	while (!q1.empty()) {
		int x = q1.front().first;
		int y = q1.front().second;
		q1.pop();

		for (int i = 0; i < 4; ++i) {
			int xx = x + dx[i];
			int yy = y + dy[i];

			if (xx < 0 || xx >= r || yy < 0 || yy >= c) continue; // 미로 밖이면 continue
			if (firetime[xx][yy] >= 0 || maze[xx][yy] == '#') continue; // 이미 타고 있는 곳이나 벽이라면 continue

			// 둘 다 아니면 불 이동
			firetime[xx][yy] = firetime[x][y] + 1;
			q1.push(make_pair(xx, yy));
		}
	}

	while (!q2.empty()) {
		int x = q2.front().first;
		int y = q2.front().second;
		q2.pop();

		for (int i = 0; i < 4; ++i) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			// 탈출했으면 그대로 종료
			if (xx < 0 || xx >= r || yy < 0 || yy >= c) {
				cout << movetime[x][y] + 1;
				return 0;
			}

			// 탈출 못했다면 체크
			if (movetime[xx][yy] >= 0 || maze[xx][yy] == '#') continue; // 이미 간 곳이나 벽을 만나면 continue
			else if (firetime[xx][yy] != -1 && firetime[xx][yy] <= movetime[x][y] + 1) continue; // 불이 먼저 도달하는 곳이어도 continue

			// 위 두 조건이 아니라면 다음 요소 체크
			movetime[xx][yy] = movetime[x][y] + 1;
			q2.push(make_pair(xx, yy));
		}
	}

	// 다 했는데 탈출 못했으면 IMPOSSIBLE 출력
	cout << "IMPOSSIBLE";

	return 0;
}
