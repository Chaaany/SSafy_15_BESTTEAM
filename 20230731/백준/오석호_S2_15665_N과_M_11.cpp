#include <iostream>
#include <set>
#include <vector>
#include <algorithm>
using namespace std;

int n, m;
int arr[7];
int target[7];
set<vector<int>> s;

void backtrack(int cnt) {
	if (cnt == m) {
		vector<int> v;
		for (int i = 0; i < m; ++i) {
			v.push_back(target[i]);
			if (v.size() == m) s.insert(v);
		}
	}
	else {
		for (int i = 0; i < n; ++i) {
			target[cnt] = arr[i];
			backtrack(cnt + 1);
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 15665 N과 M (11)
	// 백트래킹
	cin >> n >> m;
	for (int i = 0; i < n; ++i) cin >> arr[i];
	sort(arr, arr + n);
	backtrack(0);

	for (vector<int> v: s) {
		for (int i : v) cout << i << " ";
		cout << '\n';
	}
	
	return 0;
}
