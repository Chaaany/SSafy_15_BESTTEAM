#include <iostream>
#include <string>
using namespace std;

int aCnt = 0;
int bCnt = 0;
int cCnt = 0;
bool chk = false;

bool dp[51][51][51][4][4] = { 0 };

void recur(int a, int b, int c, string s, int t1, int t2) {
	if (chk || dp[a][b][c][t1][t2]) return;
	dp[a][b][c][t1][t2] = true;
	if (a == aCnt && b == bCnt && c == cCnt) {
		cout << s;
		chk = true;
		return;
	}
	if (a < aCnt) recur(a + 1, b, c, s + 'A', 0, t1);
	if (b < bCnt && t1 != 1) recur(a, b + 1, c, s + 'B', 1, t1);
	if (c < cCnt && t1 != 2 && t2 != 2)recur(a, b, c + 1, s + 'C', 2, t1);
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);	
	cout.tie(NULL);

	// 14238 출근 기록
	// DP
	string s;
	cin >> s;
	for (int i = 0; i < s.size(); ++i) {
		if (s[i] == 'A') ++aCnt;
		else if (s[i] == 'B') ++bCnt;
		else ++cCnt;
	}
	recur(0, 0, 0, "", '4', '4');
	if (!chk) cout << -1;
	
	return 0;
}
