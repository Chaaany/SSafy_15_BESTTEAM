#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 8979 올림픽
	// 구현, 정렬
	int n, k, idx;
	int g[1001] = { 0 };
	int s[1001] = { 0 };
	int b[1001] = { 0 };
	int ans = 1;
	cin >> n >> k;

	// 입력값 받기
	for (int i = 0; i < n; ++i) {
		cin >> idx;
		cin >> g[idx] >> s[idx] >> b[idx];
	}

	// 브루트포스
	for (int i = 1; i <= n; ++i) {
		if (g[i] > g[k]) ++ans;
		else if (g[i] == g[k]) {
			if (s[i] > s[k]) ++ans;
			else if (s[i] == s[k]) {
				if (b[i] > b[k]) ++ans;
			}
		}
	}

	// 출력
	cout << ans;

	return 0;
}
