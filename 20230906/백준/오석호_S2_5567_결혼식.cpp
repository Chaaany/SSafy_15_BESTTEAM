#include <iostream>
using namespace std;

int n, m, a, b;
int dist[501][501];

// 플로이드와샬인데, 상근이는 항상 1임
void fw() {
	for (int i = 2; i <= n; ++i) {
		for (int j = 2; j <= n; ++j) {
			if (dist[1][i] + dist[i][j] < dist[1][j]) dist[1][j] = dist[1][i] + dist[i][j];
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 5567 결혼식
	// 플로이드와샬
	int ans = 0;
	cin >> n >> m;
	
	// 거리 벌려놓기
	for (int i = 1; i <= n; ++i) {
		for (int j = 1; j <= n; ++j) {
			dist[i][j] = 9999;
		}
	}

	// 입력받기
	for (int i = 0; i < m; ++i) {
		cin >> a >> b;
		dist[a][b] = 1;
		dist[b][a] = 1;
	}

	fw();

	// 친구는 1, 친구의 친구는 2니까 2 이하만 걸러내기
	for (int i = 2; i <= n; ++i) {
		if (dist[1][i] <= 2) ++ans;
	}

	cout << ans;

	return 0;
}
