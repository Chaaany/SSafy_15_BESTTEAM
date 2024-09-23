#include <iostream>
#include <queue>
using namespace std;

int dist[300001]; // 각 도시까지 가는 최단거리를 담은 배열 (n이 최대 30만이니 30만 + 1로 설정)
vector<int> v[300001]; // idx에서 갈 수 있는 도시를 담은 벡터 (n이 최대 30만이니 30만 + 1로 설정)

void dijkstra(int idx) {
	dist[idx] = 0;
	queue<int> q;
	q.push(idx); // 최초값 큐에 넣기
	while (!q.empty()) {
		int curr = q.front();
		q.pop();
		for (int i = 0; i < v[curr].size(); ++i) {
			// 갈 수 있는 곳을 모두 확인하고 최단거리 여부 판단해서 dist 갱신
			int next = v[curr][i];
			if (dist[next] > dist[curr] + 1) {
				dist[next] = dist[curr] + 1;
				q.push(next);
			}
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 18352 특정 거리의 도시 찾기
	// 그래프, 다익스트라 (모든 도로의 길이가 1이지만..)
	int n, m, k, x, s, e;
	cin >> n >> m >> k >> x;

	// 초기화 (K의 값이 최대 30만이므로 30만 + 1로 초기화)
	for (int i = 1; i <= n; ++i) dist[i] = 300001;

	// 입력
	for (int i = 0; i < m; ++i) {
		cin >> s >> e;
		v[s].push_back(e);
	}

	// 출발 위치를 설정하고 다익스트라 돌리기
	dijkstra(x);

	// 체크 (하나도 없으면 -1 출력)
	bool chk = false;
	for (int i = 1; i <= n; ++i) {
		if (dist[i] == k) {
			chk = true;
			cout << i << '\n';
		}
	}
	if (!chk) cout << -1;

	return 0;
}
