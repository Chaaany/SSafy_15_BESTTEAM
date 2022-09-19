#include <iostream>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    // 20925 메이플스토리
    // DP
    int c[200] = { 0 }; // 각 사냥터 별 입장 최소 경험치
    int e[200] = { 0 }; // 각 사냥터 별 분당 얻는 경험치
    int t[200][200] = { 0 }; // 사냥터 이동시에 드는 시간
    int dp[1001][201] = { 0 }; // 특정 시간대에 특정 사냥터에 위치했을 때 얻을 수 있는 최대 경험치
    int n, vt; // 사냥터 수, 방학 기간
    cin >> n >> vt;

    // 입장최소경험치(c) 랑 1분마다 얻는 경험치(e) 입력받기
    for (int i = 0; i < n; ++i) {
        cin >> c[i] >> e[i];
    }
    // 이동에 걸리는 시간 입력받기
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            cin >> t[i][j];
        }
    }

    // 시간별로 최대값 찾기
    for (int i = 0; i < vt; ++i) {
        for (int j = 0; j < n; ++j) {
            // 같은 사냥터에서 한번 더 사냥할 수 있다면 - 기존 값에 e[j]를 더한 것과 다음 시간대의 값을 비교해서 큰 값을 dp에 넣음
            if (dp[i][j] >= c[j]) dp[i + 1][j] = max(dp[i + 1][j], dp[i][j] + e[j]);
            // 다른 사냥터로 이동하는 경우 - 모든 케이스 살피기
            for (int k = 0; k < n; ++k) {
                // j에서 k로 옮겼을 때의 시간과 입장조건을 고려 (옮겼을 때의 시간이 방학시간 이하여야 하고, k사냥터 입장조건을 만족한 상태여야한다)
                // 못옮겼을 때와 옮겼을 때 중에서 max값을 dp[i+t[j][k]][k]에 넣어준다
                if (i + t[j][k] <= vt && dp[i][j] >= c[k]) dp[i + t[j][k]][k] = max(dp[i][j], dp[i + t[j][k]][k]);
            }
        }
    }

    // vt시간에 모든 사냥터에서 얻을 수 있는 경험치중 가장 높은 경험치를 출력한다 
    int ans = 0;
    for (int i = 0; i < n; ++i) {
        if (ans < dp[vt][i]) ans = dp[vt][i];
    }
    cout << ans;

    return 0;
}
