#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1719 택배
	// 플로이드와샬
	int dist[201][201] = { 0 }; // 거리저장
	int ans[201][201] = { 0 }; // 정답
	int n, m;
	cin >> n >> m;

	// 초기화
	for (int i = 0; i < 201; ++i) {
		for (int j = 0; j < 201; ++j) {
			if (i != j) dist[i][j] = 2000001; // 아무리 멀어도 2000000보다는 덜 멀다
		}
	}

	for (int i = 0; i < m; ++i) {
		int from, to, cost;
		cin >> from >> to >> cost;
		// 연결되어있는 친구들은 우선 최단거리라고 가정하고 넣음
		dist[from][to] = cost;
		dist[to][from] = cost;
		ans[from][to] = to;
		ans[to][from] = from;
	}

	// 플로이드와샬
	for (int k = 1; k <= n; ++k) {
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				if (dist[i][j] > dist[i][k] + dist[k][j]) {
					dist[i][j] = dist[i][k] + dist[k][j]; // dist 갱신
					ans[i][j] = ans[i][k]; // i에서 j로 가는 길의 최단경로는 i에서 k로 갈 때의 최단경로와 같아짐
				}
			}
		}
	}

	// 출력
	for (int i = 1; i <= n; ++i) {
		for (int j = 1; j <= n; ++j) {
			if (i == j) cout << "- ";
			else cout << ans[i][j] << " ";
		}
		cout << '\n';
	}
	
	return 0;
}
