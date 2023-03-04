#include <iostream>
#include <algorithm>
using namespace std;

int num[1001];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(NULL);

	  // 10986 나머지 합
    // 누적합

    int n, m, input;
    cin >> n >> m;

    int sum = 0;
    long long ans = 0;

    for (int i = 0; i < n; ++i) {
        cin >> input;
        sum += (input % m);
        sum = sum % m;
        ++num[sum];
    }
    
    for (int i = 0; i < m; ++i) {
        if (num[i]) ans += ((long long)num[i] * (long long)(num[i] - 1)) / 2;
    }

    cout << ans + num[0];

    return 0;
}
