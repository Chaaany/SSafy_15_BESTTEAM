#include <iostream>
#include <algorithm>
using namespace std;

int minValue = 1000000001; // 횟수

void dfs(long long a, int b, int cnt) {
	if (a > b) return;
	else if (a == b) minValue = min(minValue, cnt);
	dfs(a * 2, b, cnt + 1);
	dfs(a * 10 + 1, b, cnt + 1);
}

// 16953 A->B
// DFS

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	int a, b;
	cin >> a >> b;

	dfs(a, b, 1);
	
	if (minValue == 1000000001) cout << -1;
	else cout << minValue;

	return 0;
}
