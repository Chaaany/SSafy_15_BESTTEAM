#include <iostream>
#include <vector>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1943 동전 분배
	// DP
	int n, value, cnt;
	int dp[50001] = { 0 }; // 해당 금액을 만들 수 있는 지 여부 판단
	vector<pair<int, int>> v; // 코인 담아두는 벡터
	for (int t = 0; t < 3; ++t) {
		int sum = 0;
		cin >> n;

		// dp배열 초기화
		for (int i = 0; i < 50001; ++i) dp[i] = 0;
		// 벡터 초기화
		v.clear();

		for (int i = 0; i < n; ++i) {
			cin >> value >> cnt;
			v.push_back(make_pair(value, cnt));
			sum += value * cnt;
		}
		if (sum % 2 == 1) {
			cout << 0 << '\n';
			continue;
		}

		dp[0] = 1; // 0원이니까 무조건 가능
		for (int i = 0; i < n; ++i) {
			for (int j = sum / 2; j >= 0; --j) { // 타겟금액
				// 위에서부터 내려오는 이유는?? 만약 1원짜리가 1개만 있다고 할 때
				// 이미 dp[1]이 체크 되었음에도 다음 j에 의해 d[2]가 체크되고... dp[50000]까지 체크되는 불상사가 발생할 수 있기 때문
				if (j - v[i].first >= 0 && j - v[i].first <= 50000 && dp[j - v[i].first]) {
					// 이전 단계에서 만들 수 있는 금액을 바탕으로 i번째 코인을 넣은 다음 금액이 유효범위 안에 들어간다면?
					// 그 개수만큼 만들 수 있는 금액들을 추가
					for (int k = 0; k < v[i].second; ++k) {
						if(j + k * v[i].first <= sum / 2) dp[j + k * v[i].first] = 1;
					}
				}
			}
		}
		
		if (dp[sum / 2] == 1) cout << 1 << '\n';
		else cout << 0 << '\n';
	}

	return 0;
}
