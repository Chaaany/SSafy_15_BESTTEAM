#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool cmp(pair<int, int> p1, pair<int, int> p2) {
    if (p1.second < p2.second) return true;
    else if (p1.second > p2.second) return false;
    return p1.first < p1.second;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    // 1263 시간 관리
    // 그리디

    int n, t, s;
    int time = 0;
    int ans = 100000;
    bool chk = true;
    vector<pair<int, int>> v;
    cin >> n;
    for (int i = 0; i < n; ++i) {
        cin >> t >> s;
        v.push_back(make_pair(t, s));
    }

    sort(v.begin(), v.end(), cmp);

    for (int i = 0; i < n; ++i) {
        time += v[i].first;
        if (time > v[i].second) {
            chk = false;
            break;
        }
        int tmp = v[i].second - time;
        if (tmp < ans) {
            ans = tmp;
        }
    }

    if (chk) cout << ans;
    else cout << -1;
  
    return 0;
}
