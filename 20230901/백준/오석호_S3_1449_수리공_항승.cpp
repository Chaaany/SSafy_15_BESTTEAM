#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1449 수리공 항승
	// 그리디
	int n, l, x;
	vector<int> v;
	cin >> n >> l;
	for (int i = 0; i < n; ++i) {
		cin >> x;
		v.push_back(x);
	}
	sort(v.begin(), v.end());

	int ans = 1;
	int tapeIdx = l - 1;
	for (int i = 0; i < n - 1; ++i) {
		if (v[i + 1] - v[i] <= tapeIdx) tapeIdx -= v[i + 1] - v[i];
		else {
			tapeIdx = l - 1;
			++ans;
		}
	}
	cout << ans;

	return 0;
}
