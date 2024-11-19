#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 20044 Project Teams
	// 정렬, 그리디
	int n, w;
	vector<int> v;
	cin >> n;
	n *= 2; // 학생수는 2n

	for (int i = 0; i < n; ++i) {
		cin >> w;
		v.push_back(w);
	}
	sort(v.begin(), v.end());

	// 앞뒤 하나씩 뽑아서 더하기 (한팀은 무조건 2명)
	int ans = 500000001;
	for (int i = 0; i < n; ++i) {
		ans = min(ans, v[i] + v[n - i - 1]);
	}
	cout << ans;

	return 0;
}
