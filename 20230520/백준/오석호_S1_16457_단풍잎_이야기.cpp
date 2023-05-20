#include <iostream>
#include <vector>
using namespace std;

int n, m, k, input;
vector<int> v[100];
bool chk[100];
int ans = 0;

// s는 선택한 스킬, cnt는 얼마나 dfs를 들어갔는지
void dfs(int s, int cnt) {
	// 끝 처리
	if (cnt == n) {
		int tmp = 0;
		for (int i = 0; i < m; ++i) {
			bool chk2 = true;
			for (int j = 0; j < k; ++j) {
				if (!chk[v[i][j]]) {
					chk2 = false;
					break;
				}
			}
			// 가능한 케이스 체크
			if (chk2) ++tmp;
		}
		if (ans < tmp) ans = tmp;
		return;
	}
	// dfs
	for (int i = s; i <= 2 * n; ++i) {
		if (!chk[i]) {
			chk[i] = true;
			dfs(i + 1, cnt + 1);
			chk[i] = false;
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 16457 단풍잎 이야기
	// 브루트포스
	cin >> n >> m >> k;
	for (int i = 0; i < m; ++i) {
		for (int j = 0; j < k; ++j) {
			cin >> input;
			v[i].push_back(input);
		}
	}

	dfs(1, 0);
	cout << ans;										
		
	return 0;
}
