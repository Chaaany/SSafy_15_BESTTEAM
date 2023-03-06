#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 15483 최소 편집
	// dp
	int dp[1001][1001] = { 0 };
	string s1, s2;
	
	cin >> s1 >> s2;
	// dp값 글자수대로 초기화 (아무것도 없는거에서 해당 문자열을 만든다고 생각)
	for (int i = 1; i <= s1.size(); ++i) dp[i][0] = i;
	for (int i = 1; i <= s2.size(); ++i) dp[0][i] = i;
	// 비교과정
	for (int i = 1; i <= s1.size(); ++i) {
		for (int j = 1; j <= s2.size(); ++j) {
			// 앞에서부터 비교해서 해당 인덱스의 값이 같으면 dp배열 이전 인덱스값 가져오기
			if (s1[i - 1] == s2[j - 1]) dp[i][j] = dp[i - 1][j - 1];
			// 그게 아니면 자신 인덱스(i-1, j-1)를 기준으로 i+1, j+1, 둘 다 +1한 곳 중에서 최솟값을 찾은 후 +1을 한 것을 dp[i][j]에 넣기
			else dp[i][j] = min(dp[i - 1][j - 1], min(dp[i][j - 1], dp[i - 1][j])) + 1;
		}
	}
	
	cout << dp[s1.size()][s2.size()];

	return 0;
}
