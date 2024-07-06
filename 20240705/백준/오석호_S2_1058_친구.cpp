#include <iostream>
#include <vector>
#include <unordered_set>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1058 친구
	// 그래프
	int n;
	vector<int> v[50];
	vector<int> cnt;

	cin >> n;
	char temp;
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			cin >> temp;
			if (temp == 'Y') v[i].push_back(j);
		}
	}

	unordered_set<int> friends;
	for (int i = 0; i < n; ++i) {
		for (auto elem : v[i]) {
			friends.insert(elem);
			for (auto elem2 : v[elem]) {
				if (elem2 != i) friends.insert(elem2);
			}
		}
		cnt.push_back(friends.size());
		friends.clear();
	}

	sort(cnt.begin(), cnt.end());
	cout << cnt[n - 1];

	return 0;
}
