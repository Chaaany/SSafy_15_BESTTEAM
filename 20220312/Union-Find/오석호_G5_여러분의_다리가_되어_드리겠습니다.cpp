#include <iostream>
#include <algorithm>

using namespace std;

int parent[300001];

int find(int x) {
    if (x == parent[x]) return x;
    return parent[x] = find(parent[x]);
}

void uni(int a, int b) {
    a = find(a);
    b = find(b);
    if (a < b) parent[b] = a;
    else parent[a] = b;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    // 17352 여러분의 다리가 되어 드리겠습니다!
    // Union-Find

    int n, a, b;
    cin >> n;

    // 초기화
    for (int i = 1; i <= n; ++i) {
        parent[i] = i;
    }

    // 입력받아서 유니온
    for (int i = 0; i < n - 2; ++i) {
        cin >> a >> b;
        uni(a, b);
    }
    
    cout << 1 << " ";

    for (int i = 2; i <= n; ++i) {
        if (find(1) != find(i)) {
            cout << i;
            break;
            // 아무거나 하나만 연결하면 되므로
        }
    }

    return 0;
}
