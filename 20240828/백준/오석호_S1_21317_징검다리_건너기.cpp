#include <iostream>
#include <cmath>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 21317 징검다리 건너기
	// DP
	int n, k, a, b;
	int dp[21][2] = { 0 }; // 앞은 idx까지 이동할 때 에너지 사용량 최소값, 뒤는 매우 큰 점프 사용여부
	pair<int, int> jump[21];

	// 돌 개수 n 받기
	cin >> n;
	
	// 점프들 등록
	for (int i = 1; i < n; ++i) {
		cin >> a >> b;
		jump[i] = make_pair(a, b);
	}

	// 매우 큰 점프에 사용되는 에너지인 k 받기
	cin >> k;

	// 초기화 (1점프에 최대 5000, 돌은 20개이므로 10만을 넘지 않는다)
	for (int i = 2; i < 21; ++i) {
		dp[i][0] = 100001;
		dp[i][1] = 100001;
	}

	// 초기값 설정
	dp[2][0] = jump[1].first; 
	dp[3][0] = min(jump[1].first + jump[2].first, jump[1].second); // 작은 점프 2번이랑 큰점프 1번 비교

	for (int i = 4; i <= n; ++i) {
		// 매우 큰 점프 안한 케이스
		dp[i][0] = min(jump[i - 1].first + dp[i - 1][0], jump[i - 2].second + dp[i - 2][0]);
		// 매우 큰 점프 한 케이스 (이미 매우 큰 점프를 사용한 케이스와 이번 턴에 매우 큰 점프를 사용한 케이스를 비교)
		dp[i][1] = min(min(jump[i - 1].first + dp[i - 1][1], jump[i - 2].second + dp[i - 2][1]), k + dp[i - 3][0]);
	}

	cout << min(dp[n][0], dp[n][1]);

	return 0;
}
