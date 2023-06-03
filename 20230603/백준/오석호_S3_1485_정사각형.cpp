#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1485 정사각형
	// 기하학
	int t, a, b;
	cin >> t;
	while(t--) {
		vector<pair<int, int>> v; // 점
		vector<double> v2; // 길이
		for (int i = 0; i < 4; ++i) {
			cin >> a >> b;
			v.push_back(make_pair(a, b));
		}
		// 어짜피 루트씌우나 안씌우나 똑같으니 걍 안씌움
		for (int i = 0; i < 4; ++i) {
			for (int j = 0; j < i; ++j) v2.push_back(pow(abs(v[i].first - v[j].first), 2) + pow(abs(v[i].second - v[j].second), 2));
		}
		
		// 앞 4개가 같고 뒤 2개가 같으면 정사각형
		sort(v2.begin(), v2.end());
		if (v2[0] == v2[3] && v2[4] == v2[5]) cout << 1 << '\n';
		else cout << 0 << '\n';
	}

	return 0;
}
