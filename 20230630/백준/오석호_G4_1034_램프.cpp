#include <iostream>
#include <string>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1034 램프
	// 브루트포스
	int n, m, k;
	int ans = -1;
	string s[51];
	
	cin >> n >> m;
	for (int i = 0; i < n; ++i) cin >> s[i];
	cin >> k;

	for (int i = 0; i < n; ++i) {
		int cnt = 0; // 해당 행의 0의 개수
		for (int j = 0; j < m; ++j) if (s[i][j] == '0') ++cnt;
		int tmp = 0;
		// 해당 행의 모든 전구를 켤 수 있는 경우 (k보다 꺼진 스위치 수가 적고, 홀짝이 같은 경우)
		if (cnt <= k && cnt % 2 == k % 2) {
			for (int j = 0; j < n; ++j) if (s[i] == s[j]) ++tmp; // 같은 형태의 행을 찾음
		}
		if (ans < tmp) ans = tmp;
	}

	cout << ans;
	
	return 0;
}
