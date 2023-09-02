#include <iostream>
#include <vector>
using namespace std;

vector<int> v[2001];
bool visited[2001];
int ans = 0;

void dfs(int cnt, int target) {
	if (cnt == 4) {
		ans = 1;
		return;
	}
	for (int i = 0; i < v[target].size(); ++i) {
		if (!visited[v[target][i]]) {
			visited[v[target][i]] = true;
			dfs(cnt + 1, v[target][i]);
			visited[v[target][i]] = false;
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 10323 ABCDE
	// DFS, 그래프
	int n, m, a, b;
	cin >> n >> m;
	for (int i = 0; i < m; ++i) {
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}
	for (int i = 0; i < n; ++i) {
		visited[i] = true;
		dfs(0, i);
		if (ans) break;
		visited[i] = false;
	}
	cout << ans;

	return 0;
}
