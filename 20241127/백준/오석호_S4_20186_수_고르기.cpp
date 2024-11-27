#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 20186 수 고르기
	// 정렬
	int n, k, input; 
	cin >> n >> k;
	vector<int> v;
	for (int i = 0; i < n; ++i) {
		cin >> input;
		v.push_back(input);
	}
	sort(v.begin(), v.end(), greater<>());
	// 항상 빼는 값은 k * (k - 1) / 2로 고정
	int ans = 0;
	for (int i = 0; i < k; ++i) ans += v[i];
	cout << ans - k * (k - 1) / 2;

	return 0;
}
