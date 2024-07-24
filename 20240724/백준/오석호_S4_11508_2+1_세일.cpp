#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 11508 2+1 세일
	// 그리디
    int n, c;
    int ans = 0;
    vector<int> v;

    cin >> n;

    for (int i = 0; i < n; ++i) {
        cin >> c;
        v.push_back(c);
    }

    // 내림차순정렬
    sort(v.begin(), v.end(), greater<int>());

    for (int i = 0; i < n; ++i) {
        // 최대한 비싼걸 할인받기 위해서 내림차순한다음 뒤에서 2번째마다 할인
        if (i % 3 != 2) ans += v[i];
    }

    cout << ans;

	return 0;
}
