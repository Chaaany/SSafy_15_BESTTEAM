#include <iostream>
#include <map>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    // 1713 후보 추천하기
    // 구현
    int n, r, input;
    map<int, pair<int, int>> m; // map<인덱스, pair<투표수, 사람>>
    cin >> n >> r;
    
    int cnt = 0;
    for (int i = 0; i < r; ++i) {
        cin >> input;
        // 새친구 입장
        if (m.find(input) == m.end()) {
            if (m.size() < n) m[input] = make_pair(1, i); // 사진틀 채우기
            else {
                int idx = m.begin()->first;
                pair<int, int> item = m.begin()->second;

                // 완탐 (투표수가 적거나 더 늦게 추천받았다면 삭제 타겟변경)
                for (auto a : m) {
                    if (a.second.first < item.first || a.second.first == item.first && a.second.second < item.second) {
                        idx = a.first;
                        item = a.second;
                    }
                }

                m.erase(idx);
                m[input] = make_pair(1, i);
            }
        }
        else ++m[input].first;
    }

    // 출력
    for (auto a : m) cout << a.first << " ";

    return 0;
}
