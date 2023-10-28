#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, k, r; // n은 목초지 크기, k는 소 마리수, r은 길의 수
vector<pair<int, int>> road[101][101];
bool visit[101][101];

// 오른 아래 왼 위
int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };

void dfs(int x, int y) {
	if (x < 1 || x > n || y < 1 || y > n) return;
	visit[x][y] = true;
	for (int i = 0; i < 4; ++i) {
		int xx = x + dx[i];
		int yy = y + dy[i];
		// 아직 방문 안했고, 길로 간게 아니라면 dfs 돌리기
		if (!visit[xx][yy] && find(road[x][y].begin(), road[x][y].end(), make_pair(xx, yy)) == road[x][y].end()) dfs(xx, yy);
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 14466 소가 길을 건너간 이유 6
	// dfs
	int ans = 0;
	cin >> n >> k >> r;

	// 길 체크
	for (int i = 0; i < r; ++i) {
		int a, b, c, d;
		cin >> a >> b >> c >> d;
		road[a][b].push_back(make_pair(c, d));
		road[c][d].push_back(make_pair(a, b));
	}

	// 소 위치 체크
	vector<pair<int, int>> v;
	int x, y;
	for (int i = 0; i < k; ++i) {
		cin >> x >> y;
		v.push_back(make_pair(x, y));
	}

	// 각 소마다 돌면서 길 안만나면 만나지 못하는 소 ans에 더해주기
	for (int i = 0; i < k; ++i) {
		// visit 초기화
		for (int j = 1; j <= n; ++j) {
			for (int l = 1; l <= n; ++l) visit[j][l] = false; // k를 못쓰네.. ㅠ
		}
		dfs(v[i].first, v[i].second);
		for (int j = i + 1; j < k; ++j) {
			// 만나지 못하는 소 체크
			if (!visit[v[j].first][v[j].second]) ++ans;
		}
	}

	cout << ans;

	return 0;
}
