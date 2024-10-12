#include <iostream>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(NULL);

    // 1193 분수찾기
    // 수학

    int x;
    cin >> x;

    int cnt = 0;
    int tmp = 0;
    while (x > tmp) {
        tmp += cnt + 1;
        ++cnt;
    }
    if (cnt % 2 == 0) cout << cnt - (tmp - x) << '/' << 1 + (tmp - x);
    else cout << 1 + (tmp - x) << '/' << cnt - (tmp - x);

    return 0;
}
