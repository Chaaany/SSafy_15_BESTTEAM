#include <iostream>
#include <string>
#include <vector>
using namespace std;

int distSum(string s1, string s2, string s3) {
	int ans = 0;
	for (int i = 0; i < 4; ++i) {
		if (s1[i] != s2[i]) ++ans;
		if (s2[i] != s3[i]) ++ans;
		if (s3[i] != s1[i]) ++ans;
	}
	return ans;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 20529 가장 가까운 세 사람의 심리적 거리
	// 수학, 브루트포스
	int t, n;
	string s;
	cin >> t;
	while (t--) {
		vector<string> v;
		int ans = 12;
		cin >> n;
		for (int i = 0; i < n; ++i) {
			cin >> s;
			v.push_back(s);
		}
		if (n > 32) {
			cout << 0 << '\n';
			continue;
		}
		// 아무거나 3개 골라서 거리재기 (브루트포스)
		for (int i = 0; i < n - 2; ++i) {
			for (int j = i + 1; j < n - 1; ++j) {
				for (int k = j + 1; k < n; ++k) {
					int tmp = distSum(v[i], v[j], v[k]);
					if (ans > tmp) ans = tmp;
				}
			}
		}
		cout << ans << '\n';
	}

	return 0;
}
