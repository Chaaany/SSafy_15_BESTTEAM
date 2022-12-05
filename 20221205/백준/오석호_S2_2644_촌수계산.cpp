#include <iostream>
#include <queue>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	// 2644 촌수계산
	// BFS
	int n, m, x, y, a, b;
	bool arr[101][101] = { 0 };
	int dist[101] = { 0 };
	int answer = -1;
	cin >> n >> a >> b >> m;
	// 연결그래프를 그린다
	// a부터 시작해서 b까지 가는 길을 bfs
	for (int i = 0; i < m; ++i) {
		cin >> x >> y;
		arr[x][y] = true;
		arr[y][x] = true;
	}

	// dist배열 초기화
	for (int i = 1; i <= n; ++i) {
		dist[i] = 99999999; // 임의의 큰수
	}
	
	// 앞은 도착점, 뒤는 거리
	queue<pair<int, int>> q;
	q.push(make_pair(a, 0));
	
	while (!q.empty()) {
		int target = q.front().first;
		int cnt = q.front().second;
		q.pop();

		if (target == b) {
			answer = cnt;
			break;
		}

		for (int i = 1; i <= n; ++i) {
			if (arr[target][i] && dist[i] >= cnt + 1) {
				q.push(make_pair(i, cnt + 1));
				dist[i] = cnt + 1;
			}
		}
	}

	cout << answer;

	return 0;
}
