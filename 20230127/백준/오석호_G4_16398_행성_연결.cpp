#include <iostream>
#include <vector>
#include <tuple>
#include <algorithm>
using namespace std;

int parent[1001];
vector<tuple<int, int, int>> v;

int getParent(int x) {
    if (parent[x] == x) return x;
    return parent[x] = getParent(parent[x]);
}

void unionParent(int a, int b) {
    a = getParent(a);
    b = getParent(b);
    parent[a] = b;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    // 16398 행성 연결
    // union-find
    int n, tmp;
    cin >> n;

    // 초기화
    for (int i = 1; i <= n; ++i) {
        parent[i] = i;
    }

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            cin >> tmp;
            // 삼각형의 1/2만 받아서 처리하기 - 효율성
            if (i < j) v.push_back(make_tuple(tmp, i, j));
        }
    }

    sort(v.begin(), v.end());

    long long ans = 0;
    for (int i = 0; i < v.size(); ++i) {
        int cost = get<0>(v[i]);
        if (getParent(get<1>(v[i])) != getParent(get<2>(v[i]))) { // 부모요소가 다르면
            // 두 요소 연결
            ans += cost;
            unionParent(get<1>(v[i]), get<2>(v[i]));
        }
    }

    cout << ans;

    return 0;
}
