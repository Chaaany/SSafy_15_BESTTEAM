#include <iostream>
using namespace std;

int visited[1001];
int arr[1001];
int ans;

void dfs(int v) {
	if (visited[v]) {
		++ans;
		return;
	}
	visited[v] = true;
	dfs(arr[v]);
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 10451 순열 사이클
	// DFS
	int t, n;
	cin >> t;

	// visited 배열을 만들어서 순서대로 DFS를 돌리면서 visited된 vertex를 만나면 되지 않을까?
	// 의심 1 : 순회를 안하고 그냥 한줄로 쭉 끝나는 경우도 있지 않을까 <- 이건 순열이 아니었다~!

	while (t--) {
		for (int i = 1; i <= 1000; ++i) {
			visited[i] = false;
			arr[i] = 0;
		}
		ans = 0;
		
		// 배열 초기화
		cin >> n;
		for (int i = 1; i <= n; ++i) cin >> arr[i];

		// 정답 추출
		for (int i = 1; i <= n; ++i) if (!visited[i]) dfs(i);

		cout << ans << '\n';
	}

	return 0;
}
