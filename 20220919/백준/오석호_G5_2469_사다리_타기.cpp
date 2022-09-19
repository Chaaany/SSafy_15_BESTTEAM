#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(NULL);

    // 2469 사다리 타기
    // 구현
    int k, n;
    string s, ladder;
    cin >> k >> n;
    vector<char> above;
    vector<char> below;
    char alpha = 65;

    // 먼저 가져다 박기
    for (int i = 0; i < k; ++i) {
        above.push_back(alpha);
        ++alpha;
    }
    
    cin >> s;
    for (int i = 0; i < k; ++i) below.push_back(s[i]);
    
    // 물음표 기준으로 위아래 요소 처리하기
    int topIdx = 0;
    int bottomIdx = n - 1;
    for (; topIdx < n; ++topIdx) {
        cin >> ladder;
        for (int j = 0; j < k - 1; ++j) {
            if (ladder[j] == '?') break;
            if (ladder[j] == '-') {
                char tmp = above[j + 1];
                above[j + 1] = above[j];
                above[j] = tmp;
            }
        }
        if (ladder[0] == '?') break;
    }
    
    // ? 아래쪽 요소를 받아서 순서대로 저장해두기
    vector<string> bottomLadders;
    for (int i = topIdx + 1; i < n; ++i){
        cin >> ladder;
        bottomLadders.push_back(ladder);
    }
    
    // 거꾸로 꺼내면서 ? 바로 아래까지 가져오기
    for (int i = bottomLadders.size() - 1; i >= 0; --i) {
        for (int j = 0; j < k; ++j) {
            if (bottomLadders[i][j] == '-') {
                char tmp = below[j + 1];
                below[j + 1] = below[j];
                below[j] = tmp;
            }
        }
    }
    
    // 값 비교
    vector<char> ans;
    for (int i = 0; i < k - 1; ++i) {
        if (above[i] == below[i]) ans.push_back('*');
        else if (above[i] == below[i+1] && above[i+1] == below[i]) {
            ans.push_back('-');
            if(i != k-2) {
                ++i;
                ans.push_back('*');
            }
        }
        else break;
    }
    
    // 예외처리
    if (ans.size() != k-1) {
        ans.clear();
        for (int i = 0; i < k-1; ++i) ans.push_back('x');
    }
    
    // 
    for (int i = 0; i < k-1; ++i) cout << ans[i];
    
    return 0;
}
