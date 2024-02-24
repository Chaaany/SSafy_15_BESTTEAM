#include <iostream>
using namespace std;

int arr[101];
bool v[101];
int ansCnt = 0;
int ans[101];

void dfs(int s, int now) {
	// 이미 방문한 곳인데
	if (v[now]) {
		// start와 같은 곳이면 ans 등록
		if (s == now) {
			ans[ansCnt++] = s;
		}
	}
	else {
		v[now] = true;
		dfs(s, arr[now]);
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 2668 숫자고르기
	// DFS
	int n;
	cin >> n;
	for (int i = 1; i <= n; ++i) cin >> arr[i];

	for (int i = 1; i <= n; ++i) {
		for (int j = 1; j <= n; ++j) v[j] = false;
		dfs(i, i);
	}

	// 모든 사이클을 다 더하면 된다
	cout << ansCnt << '\n';
	for (int i = 0; i < ansCnt; ++i) cout << ans[i] << '\n';

	return 0;
}
