#include <iostream>
#include <queue>
#include <tuple>
using namespace std;

int n, m, hx, hy, ex, ey;
bool arr[1001][1001]; // 맵
bool v[1001][1001][2]; // 벽을 뚫은 경우와 안뚫은 경우로 나누어서 생각
int dr[4] = { 1, 0, -1, 0 };
int dc[4] = { 0, -1, 0, 1 };

int bfs(int r, int c) {
	queue<tuple<int, int, bool, int>> q; // 현재 가로, 현재 세로, 벽뚫 여부, 거리
	q.push(make_tuple(r - 1, c - 1, false, 0));
	v[r][c][0] = true;
	while (!q.empty()) {
		int rr = get<0>(q.front());
		int cc = get<1>(q.front());
		bool bb = get<2>(q.front());
		int ww = get<3>(q.front());
		q.pop();

		// 도착지에 도착하면 return
		if (rr == ex - 1 && cc == ey - 1) return ww;

		for (int i = 0; i < 4; ++i) {
			int rrr = rr + dr[i];
			int ccc = cc + dc[i];

			if (rrr < 0 || rrr >= n || ccc < 0 || ccc >= m) continue;
			// 벽을 아직 안뚫었고, 뚫어야 되는 곳을 가는 경우
			if (arr[rrr][ccc] && !bb && !v[rrr][ccc][1]) {
				q.push(make_tuple(rrr, ccc, !bb, ww + 1));
				v[rrr][ccc][1] = true;
			}
			// 벽을 아직 안뚫었고, 안뚫어도 되는 곳을 가는 경우
			if (!arr[rrr][ccc] && !bb && !v[rrr][ccc][0]) {
				q.push(make_tuple(rrr, ccc, bb, ww + 1));
				v[rrr][ccc][0] = true;
			}
			// 벽을 이미 뚫었고, 안뚫어도 되는 곳을 가는 경우
			if (!arr[rrr][ccc] && bb && !v[rrr][ccc][1]) {
				q.push(make_tuple(rrr, ccc, bb, ww + 1));
				v[rrr][ccc][1] = true;
			}
		}
	}

	return -1;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(NULL);

	// 14923 미로 탈출
	// BFS
	cin >> n >> m >> hx >> hy >> ex >> ey;
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j) cin >> arr[i][j];
	}

	cout << bfs(hx, hy);

	return 0;
}
