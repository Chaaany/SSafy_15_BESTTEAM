#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 17615 볼 모으기
	// 그리디
	int n;
	string s;
	cin >> n >> s;

	int r = 0;
	int b = 0;
	int ans = 500001;
	for (int i = 0; i < s.size(); ++i) {
		if (s[i] == 'R') ++r;
		else ++b;
	}

	int cnt = 0;
	int idx = 0;
	// R모으기 (이미 모여있는거 제외)
	// 왼쪽
	cnt = r;
	while (s[idx++] == 'R') --cnt;
	ans = cnt;
	// 오른쪽
	cnt = r;
	idx = n - 1;
	while (s[idx--] == 'R') --cnt;
	ans = min(ans, cnt);

	// B모으기
	// 왼쪽
	cnt = b;
	idx = 0;
	while (s[idx++] == 'B') --cnt;
	ans = min(ans, cnt);
	// 오른쪽
	cnt = b;
	idx = n - 1;
	while (s[idx--] == 'B') --cnt;
	ans = min(ans, cnt);

	cout << ans;

	return 0;
}
