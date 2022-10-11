#include <iostream>
#include <vector>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    // 20542 받아쓰기
    // dp
    vector<vector<int>> dp;
    int n, m;
    string myAns, realAns;
    cin >> n >> m;
    cin >> myAns >> realAns;
    
    // dp배열 초기화
    for (int i = 0; i <= myAns.size(); ++i) {
        vector<int> tmp;
        for (int j = 0; j <= realAns.size(); ++j) {
            tmp.push_back(0);
        }
        dp.push_back(tmp);
    }

    // 1,1부터 시작
    // 위 아래 대각선 비교
    for (int i = 0; i <= myAns.size(); ++i) {
        for (int j = 0; j <= realAns.size(); ++j) {
            if (i == 0) dp[i][j] = j;
            else if (j == 0) dp[i][j] = i;
            else {
                if (myAns[i-1] == realAns[j-1] || myAns[i-1] == 'i' && realAns[j-1] == 'j' || myAns[i-1] == 'i' && realAns[j-1] == 'l' || myAns[i-1] == 'v' && realAns[j-1] == 'w') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else dp[i][j] = min(dp[i - 1][j] + 1, min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1));
            }
            
        }
    }

    cout << dp[n][m] << endl;
  
    return 0;
}
