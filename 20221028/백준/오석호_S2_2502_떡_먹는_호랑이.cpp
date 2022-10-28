#include <iostream>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    // 2502 떡 먹는 호랑이
    // 브루트포스, 구현
    int arr[31];
    int n, t;
    cin >> n >> t;
    
    // 피보나치 구하기
    // 0 1 1 2 3 5 8 13 21 34 55 89
    arr[0] = 0;
    arr[1] = 1;

    for (int i = 2; i < 31; ++i) {
        arr[i] = arr[i - 1] + arr[i - 2];
    }

    // 브루트포스
    int a = 1;
    int b = 0;
    while (1) {
        if (arr[n] * a + arr[n - 1] * b == t) break;
        else {
            if (arr[n] * a > t) {
                a = 1;
                ++b;
            }
            else ++a;
        }
    }

    cout << a << '\n' << a + b;

    return 0;
}
