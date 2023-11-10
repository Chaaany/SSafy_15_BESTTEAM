#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

int dx[] = { 0, 1, 0, -1 };
int dy[] = { 1, 0, -1, 0 };
int m[5][5];

int bfs(int r, int c) {
	queue<pair<int, pair<int, int>>> q;
	q.push(make_pair(0, make_pair(r, c))); // 현재 위치 초기값
	bool v[5][5] = { 0 }; // 방문 체크용
	v[r][c] = true;

	// bfs
	while (!q.empty()) {
		int x = q.front().second.second;
		int y = q.front().second.first;
		int move = q.front().first;
		q.pop();

		// 1 도착하면 종료
		if (m[y][x] == 1) return move;
		for (int i = 0; i < 4; ++i) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if (0 <= xx && xx <= 4 && 0 <= yy && yy <= 4) {
				if (!v[yy][xx] && m[yy][xx] != -1) {
					v[yy][xx] = true;
					q.push(make_pair(move + 1, make_pair(yy, xx)));
				}
			}
		}
	}

	return -1;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 25416 빠른 숫자 탐색
	// BFS
	int r, c;

	// 5*5 입력
	for (int i = 0; i < 5; ++i) {
		for (int j = 0; j < 5; ++j) {
			cin >> m[i][j];
		}
	}

	cin >> r >> c;
	cout << bfs(r, c);

	return 0;
}
