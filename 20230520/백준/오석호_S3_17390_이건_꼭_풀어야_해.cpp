#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 17390 이건 꼭 풀어야 해
	// 누적합
	int n, q, input, l, r;
	cin >> n >> q;
	vector<int> v;
	v.push_back(0);
	for (int i = 1; i <= n; ++i) {
		cin >> input;
		v.push_back(input);
	}
	sort(v.begin(), v.end());

	for (int i = 1; i <= n; ++i) v[i] += v[i - 1];

	for (int i = 0; i < q; ++i) {
		cin >> l >> r;
		// 누적합 배열인 v가 있으니까 하나하나 다 더해주기보다 v[r]에서 v[l-1] 빼면 바로 나옴
		cout << v[r] - v[l - 1] << '\n';
	}
		
	return 0;
}
