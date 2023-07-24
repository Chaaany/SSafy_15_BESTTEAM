#include <iostream>
#include <vector>
using namespace std;
int n, k, input;
int root = 0;
int ans = 0;
vector<int> v[51];

bool dfs(int node) {
	// 노드 지우기
	if (node == k) return false;
	
	// 자식이 없으면 리프노드
	if (v[node].empty()) {
		++ans;
		return true;
	}
	
	// 자식이 있으면 dfs
	for (int i = 0; i < v[node].size(); ++i) {
		bool chk = dfs(v[node][i]);
		// 만약 지운 노드가 node의 유일한 자식이면 부모가 리프노트가 된다
		if (chk == false && v[node].size() == 1) ++ans;
	}
	return true;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1068 트리
	// DFS, 그래프
	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> input;
		// 루트를 찾거나 v[부모]에 자식 넣기
		if (input == -1) root = i;
		else v[input].push_back(i);
	}
	cin >> k;
	
	// 리프개수 찾기
	dfs(root);

	// 출력
	cout << ans;

	return 0;
}
