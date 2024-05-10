#include <iostream>
#include <cstring>
using namespace std;

int arr[401][401];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(NULL);

    // 1956 운동
    // 플로이드와샬

    for (int i = 1; i < 401; ++i) {
        for (int j = 1; j < 401; ++j) {
            if (i != j) arr[i][j] = 10000000; // 최소한 4000000보다는 커야 한다!
        }
    }

    int v, e;
    int s, f, c; // 시작, 끝, 비용
    cin >> v >> e;
    for (int i = 0; i < e; ++i) {
        cin >> s >> f >> c;
        arr[s][f] = c;
    }

    for (int k = 1; k <= v; ++k) {
        for (int i = 1; i <= v; ++i) {
            for (int j = 1; j <= v; ++j) {
                if (arr[i][j] > arr[i][k] + arr[k][j]) arr[i][j] = arr[i][k] + arr[k][j];
            }
        }
    }

    int min = 50000000; // 최소한 8000000보다는 커야 한다!

    for (int i = 1; i <= v; ++i) {
        for (int j = 1; j <= v; ++j) {
            if (i != j && arr[i][j] != 10000000 && arr[j][i] != 10000000 && min > arr[i][j] + arr[j][i]) min = arr[i][j] + arr[j][i];
        }
    }

    if (min == 50000000) cout << -1;
    else cout << min;

    return 0;
}
