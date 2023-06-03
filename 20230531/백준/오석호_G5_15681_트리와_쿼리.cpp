#include <iostream>
#include <vector>
using namespace std;

vector<int> e[100001]; // 간선들
int chk[100001]; // 방문여부
int ans[100001]; // 정답

int dfs(int node) {
	chk[node] = true;
	for (int i = 0; i < e[node].size(); ++i) {
		int child = e[node][i];
		if (!chk[child]) ans[node] += dfs(child);
	}

	return ans[node];
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 15681 트리와 쿼리
	// DFS
	int n, r, q, u, v, input;
	cin >> n >> r >> q;
	
	for (int i = 0; i < n - 1; ++i) {
		cin >> u >> v;
		e[u].push_back(v);
		e[v].push_back(u);
	}

	for (int i = 1; i <= n; ++i) ans[i] = 1; // 정답배열 초기화
	dfs(r);
	for (int i = 0; i < q; ++i) {
		cin >> input;
		cout << ans[input] << '\n';
	}

	return 0;
}
