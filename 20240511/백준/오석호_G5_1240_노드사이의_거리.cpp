#include <iostream>
#include <vector>
using namespace std;

vector<pair<int, int>> v[1001];
bool visit[1001];

void dfs(int now, int end, int dist) {
	// 종료조건
	if (now == end) {
		cout << dist << '\n';
		return;
	}

	for (int i = 0; i < v[now].size(); ++i) {
		// 다음 방문지
		int target = v[now][i].first;

		// 재방문 체크
		if (visit[target]) continue;

		// 재방문 아닌거 확인했으면 DFS
		visit[target] = true;
		int sum = dist + v[now][i].second;
		dfs(target, end, sum);
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1240 노드사이의 거리
	// DFS
	int n, m;
	int s, e, d; // 출발, 도착, 거리
	int ss, ee;
	cin >> n >> m;
	
	// 입력
	for (int i = 0; i < n - 1; ++i) {
		cin >> s >> e >> d; 
		v[s].push_back(make_pair(e, d));
		v[e].push_back(make_pair(s, d));
	}

	// 거리를 알고싷은 노드 쌍을 받아서 거리를 출력
	for (int i = 0; i < m; ++i) {
		// visit 배열 초기화
		for (int j = 0; j < 1001; ++j) visit[j] = false;

		cin >> ss >> ee;
		visit[ss] = true;
		dfs(ss, ee, 0);
	}

	return 0;
}
