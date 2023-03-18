#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1120 문자열
	// 문자열
	string a, b;
	int ans = 51;
	cin >> a >> b;
	for (int i = 0; i <= b.size() - a.size(); ++i) {
		int cnt = 0;
		for (int j = 0; j < a.size(); ++j) {
			if (a[j] != b[i + j]) ++cnt;
		}
		ans = min(ans, cnt);
	}
	cout << ans;

	return 0;
}
