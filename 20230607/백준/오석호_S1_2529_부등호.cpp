#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
using namespace std;

int k;
vector<char> signs;
vector<int> maxv;
vector<int> minv;

bool chk(string s) {
	for (int i = 0; i < k; ++i) {
		if (s == "max") {
			if (signs[i] == '<') {
				if (maxv[i] > maxv[i + 1]) return false;
			}
			else {
				if (maxv[i] < maxv[i + 1]) return false;
			}
		}
		else {
			if (signs[i] == '<') {
				if (minv[i] > minv[i + 1]) return false;
			}
			else {
				if (minv[i] < minv[i + 1]) return false;
			}
		}
	}
	return true;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 2529 부등호
    // 브루트포스
	char c;
	cin >> k;
	for (int i = 0; i < k; ++i) {
		cin >> c;
		signs.push_back(c);
	}

	for (int i = 9; i >= 9 - k; --i) maxv.push_back(i);
	while (1) {
		if (chk("max")) break;
		prev_permutation(maxv.begin(), maxv.end());
	}
	
	for (int i = 0; i <= k; ++i) minv.push_back(i);
	while (1) {
		if (chk("min")) break;
		next_permutation(minv.begin(), minv.end());
	}

	for (int i = 0; i <= k; ++i) cout << maxv[i];
	cout << '\n';
	for (int i = 0; i <= k; ++i) cout << minv[i];

	return 0;
}
