#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> v[1000001]; // 각 지점에서 연결된 연결선을 담은 벡터
int dp[1000001][2]; // 0 일반인, 1 얼리어답터

void makeDP(int node) {
	dp[node][1] = 1;
	for (int i = 0; i < v[node].size(); ++i) {
		// 방문 안했을 때만 체크
		if (dp[v[node][i]][1] == 0) {
			makeDP(v[node][i]);
			dp[node][0] += dp[v[node][i]][1]; // 부모가 일반인이면 자식은 모두 얼리어답터
			dp[node][1] += min(dp[v[node][i]][0], dp[v[node][i]][1]); // 부모가 얼리어답터면 자식은 얼리어답터여도 되고, 아니어도 됨
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 2533 사회망 서비스(SNS)
	// DP
	int n, s, e;
	cin >> n;
	
	// 트리니까 n-1개의 간선 존재
	// 간선등록
	for (int i = 0; i < n - 1; ++i) {
		cin >> s >> e;
		v[s].push_back(e);
		v[e].push_back(s);
	}

	// 1번노드부터 순서대로 체크
	makeDP(1);
	// 1번노드가 일반인일 때와 얼리어답터일 때 케이스 중 작은걸 출력
	cout << min(dp[1][0], dp[1][1]);

	return 0;
}    
