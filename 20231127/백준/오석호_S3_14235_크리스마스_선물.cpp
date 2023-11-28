#include <iostream>
#include <queue>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    // 14235 크리스마스 선물
    // 우선순위큐
    int n, a, b;
    priority_queue<int> pq;
    cin >> n;
    for (int i = 0; i < n; ++i) {
        cin >> a;
        if (a == 0) {
            if (pq.empty()) cout << "-1";
            else {
                cout << pq.top();
                pq.pop();
            }
            cout << '\n';
        }
        else {
            for (int j = 0; j < a; ++j) {
                cin >> b;
                pq.push(b);
            }
        }
    }

    return 0;
}
