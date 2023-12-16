#include <iostream>
#include <vector>
using namespace std;

int n;
bool isCycle = false;
bool visited[101];
vector<vector<int>> v(101);

void dfs(int x) {
	if (isCycle) return;
	visited[x] = true;
	for (int i = 0; i < v[x].size(); ++i) {
		if (!visited[v[x][i]]) dfs(v[x][i]);
		else if (visited[v[x][i]]) isCycle = true;
	}
	visited[x] = false;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 11581 구호물자
	// DFS
	int m, c;
	cin >> n;

	for (int i = 1; i < n; ++i) {
		cin >> m;
		for (int j = 0; j < m; ++j) {
			cin >> c;
			v[i].push_back(c);
		}
	}

	dfs(1);

	if (isCycle) cout << "CYCLE";
	else cout << "NO CYCLE";

	return 0;
}
