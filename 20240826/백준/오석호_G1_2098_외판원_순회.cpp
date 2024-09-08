#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;
int n;
int arr[17][17];
int dp[16][1 << 16];

int circuit(int node, int v) {

	// 모든 노드를 다 돌았다면 (방문비트가 1로 꽉찬 상태)
	if (v == (1 << n) - 1) {
		if (arr[node][0] == 0) return 1000000000;
		else return arr[node][0];
	}

	// 이미 최솟값이 있는 경우
	if (dp[node][v] != -1) return dp[node][v];
	

	// 없으면 찾는다
	dp[node][v] = 1000000000;
	for (int i = 0; i < n; ++i) {
		// 연결 안되어있으면 패스
		if (arr[node][i] == 0) continue;
		// 이미 방문했다면 패스
		if (v & (1 << i)) continue;
		// 둘다 안걸리면 다익스트라처럼 최솟값 갱신
		dp[node][v] = min(dp[node][v], arr[node][i] + circuit(i, v | 1 << i));
	}

	// DFS로 다 돌고 리턴값 반환
	return dp[node][v];
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 2098 외판원 순회
	// dp, 비트마스킹
	// 어디서 시작해도 똑같음..

	cin >> n;
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			cin >> arr[i][j];
		}
	}
	// dp 배열을 -1로 초기화 하는 이유는, 자기 자신은 이동하는 데에 0만큼이 걸리기 때문에..! 이 케이스를 걸러야함!
	memset(dp, -1, sizeof(dp));
	cout << circuit(0, 1);

	return 0;
}
