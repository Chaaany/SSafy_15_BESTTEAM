#include <iostream>
using namespace std;

int arr[200001];
int chk[100001];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    // 20922 겹치는 건 싫어
    // 투포인터
    int s = 0;
    int e = 0;
    int n, k;
    int maxNum = 0;
    int cnt = 0;
    cin >> n >> k;
    // arr넣기
    for (int i = 0; i < n; ++i) {
        cin >> arr[i];
    }
    // 하나씩 이동하면서 체크
    for (; e < n; ++e) {
        if (chk[arr[e]] < k) {
            ++chk[arr[e]];
            ++cnt;
        }
        else {
            while (1) {
                if (arr[s] == arr[e]) {
                    ++s;
                    break;
                }
                else {
                    --chk[arr[s]];
                }
                ++s;
                --cnt;
            }
        }
        if (maxNum < cnt) maxNum = cnt;
    }

    cout << maxNum;

    return 0;
}
