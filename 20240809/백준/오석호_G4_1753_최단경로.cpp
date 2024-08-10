#include <iostream>
#include <vector>
#include <queue>
using namespace std;

vector<pair<int, int>> edge[300001];
int d[20001];

void dijkstra(int s) {
	d[s] = 0;

	priority_queue<pair<int, int>> pq;

	// 초기값 설정
	pq.push(make_pair(0, s));

	while (!pq.empty()) {
		int curr = pq.top().second;
		int dist = -pq.top().first;

		pq.pop();

		if (d[curr] >= dist) {
			for (int i = 0; i < edge[curr].size(); ++i) {
				int next = edge[curr][i].second;
				int total = dist + edge[curr][i].first;
				if (d[next] > total) {
					d[next] = total;
					pq.push(make_pair(-total, next));
				}
			}
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1753 최단경로
	// 그래프, 다익스트라
	int v, e, s;
	cin >> v >> e >> s;

	for (int i = 1; i <= v; ++i) d[i] = 1000001;

	while (e--) {
		int start, end, cost;
		cin >> start >> end >> cost;
		edge[start].push_back(make_pair(cost, end));
	}

	dijkstra(s);

	for (int i = 1; i <= v; ++i) {
		if (d[i] == 1000001) cout << "INF" << '\n';
		else cout << d[i] << '\n';
	}

	return 0;
}
