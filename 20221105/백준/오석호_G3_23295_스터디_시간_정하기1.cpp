#include <iostream>
using namespace std;

int timeArr[100001];
int sum[100001];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    // 23295 스터디 시간 정하기 1
    // 누적합
    int n, t, k, s, e;
    cin >> n >> t;
    for (int i = 0; i < n; ++i) {
        cin >> k;
        for (int j = 0; j < k; ++j) {
            cin >> s >> e;
            ++timeArr[s];
            --timeArr[e];
        }
    }

    // 스위핑
    for (int i = 1; i <= 100000; ++i) timeArr[i] += timeArr[i - 1];

    // 누적합
    sum[0] = timeArr[0];
    for (int i = 1; i <= 100000; ++i) sum[i] += sum[i - 1] + timeArr[i];

    // 투포인터
    int ans = sum[t - 1];
    int ansIdx = 0;
    int sIdx = 0;
    int eIdx = t;

    while (eIdx < 100000) {
        ++sIdx;
        ++eIdx;
        if (ans < sum[eIdx] - sum[sIdx]) {
            ansIdx = sIdx + 1;
            ans = sum[eIdx] - sum[sIdx];
        }
    }
    cout << ansIdx << " " << ansIdx + t;

    return 0;
}
