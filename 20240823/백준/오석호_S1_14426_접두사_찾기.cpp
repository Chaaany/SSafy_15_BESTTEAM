#include <iostream>
#include <string>
#include <unordered_map>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 14426 접두사 찾기
	// 브루트포스
	int n, m;
	string s;
	unordered_map<string, bool> chk; // 체크용 map
	cin >> n >> m;
	for (int i = 0; i < n; ++i) {
		cin >> s;

		string tmp; // 접두사 체크
		for (int j = 0; j < s.size(); ++j) {
			tmp += s[j];
			chk[tmp] = true;
		}
	}

	int ans = 0;
	for (int i = 0; i < m; ++i) {
		cin >> s;
		if (chk[s]) ++ans;
	}

	cout << ans;

	return 0;
}
