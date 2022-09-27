#include <iostream>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    // 16967 배열 복원하기
    // 구현
    int h, w, x, y;
    int arr[601][601] = { 0 };
    cin >> h >> w >> x >> y;

    for (int i = 0; i < h + x; ++i) {
        for (int j = 0; j < w + y; ++j) {
            cin >> arr[i][j];
        }
    }

    for (int i = x; i < h; ++i) {
        for (int j = y; j < w; ++j) {
            arr[i][j] -= arr[i - x][j - y];
        }
    }

    // 출력
    for (int i = 0; i < h; ++i) {
        for (int j = 0; j < w; ++j) {
            cout << arr[i][j] << " ";
        }
        cout << '\n';
    }

    return 0;
}
