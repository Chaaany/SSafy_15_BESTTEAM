#include <iostream>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    // 13305 주유소
    // 그리디
    int n;
    int dist[100000] = { 0 };
    int minCost = 1000000001;
    int cost[100001] = { 0 };
    long long ans = 0;
    cin >> n;

    for (int i = 0; i < n - 1; ++i) cin >> dist[i];

    // 만약 이미 더 싼 기름을 파는 주유소를 지나왔다면 그곳에서 다음에 더 싼 기름을 파는 주유소를 만날 때까지의 거리만큼의 기름을 사면 된다
    for (int i = 0; i < n; ++i) {
        cin >> cost[i];
        if (minCost > cost[i]) minCost = cost[i];
        else cost[i] = minCost;
    }

    for (int i = 0; i < n - 1; ++i) ans += (long long)cost[i] * (long long)dist[i];

    cout << ans;

	return 0;
}
