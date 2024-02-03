#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 2512 예산
	// 이분탐색
	int n, m, input;
	vector<int> v;
	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> input;
		v.push_back(input);
	}
	cin >> m;

	sort(v.begin(), v.end());

	int s = 0;
	int e = v[n - 1];
	int ans = 0;

	while (s <= e) {
		int sum = 0;
		int mid = (s + e) / 2;
		// 특정 정수 상한액이 mid가 된다고 생각
		for (int i = 0; i < n; ++i) sum += min(v[i], mid);

		if (m >= sum) {
			ans = mid;
			s = mid + 1;
		}
		else e = mid - 1;
	}
	cout << ans;

	return 0;
}
