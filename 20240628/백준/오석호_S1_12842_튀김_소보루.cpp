#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 12842 튀김 소보루
	// 구현
	int n, s, m;
	int arr[100001] = { 0 };
	int ans = 0;
	cin >> n >> s >> m;
	for (int i = 0; i < m; ++i) cin >> arr[i];

	for (int i = 0; i < 100000; ++i) {
		for (int j = 0; j < m; ++j) {
			if (i % arr[j] == 0) {
				++ans;
				if (ans >= n - s) {
					cout << j + 1;
					return 0;
				}
			}
		}
	}

	return 0;
}
