#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1758 알바생 강호
	// 그리디, 정렬
	int n, input;
	vector<int> v;
	long long ans = 0;
	cin >> n;

	for (int i = 0; i < n; ++i) {
		cin >> input;
		v.push_back(input);
	}

	sort(v.begin(), v.end(), greater<>());

	for (int i = 0; i < n; ++i) {
		if (v[i] - i > 0) ans += v[i] - i;
	}

	cout << ans;

	return 0;
}
