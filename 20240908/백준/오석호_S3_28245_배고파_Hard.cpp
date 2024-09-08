#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 28245 배고파(Hard)
	// 비트마스킹
	long long n, m;
	cin >> n;
	
	for (int i = 0; i < n; ++i) {
		cin >> m;
		// m을 2진수로 만든 다음 1이 1개 혹은 2개인 2진수인지를 판단한다
		vector<long long> v;

		for (long long j = 0; (1ll << j) <= m; ++j) {
			if (m & (1ll << j)) v.push_back(j);
		}

		if (m == 1) cout << 0 << " " << 0;

		else if (v.size() == 1) cout << v[0] - 1 << " " << v[0] - 1;

		else if (v.size() == 2) {
			sort(v.begin(), v.end());
			cout << v[0] << " " << v[1];
		}
		
		// 그게 아니라면 앞에서부터 1 2개를 남기고 나머지를 지우거나 - 작은 케이스, 앞에서부터 두 번째 1을 올림처리해준다 - 큰 케이스
		// 그 둘을 비교해서 차이를 확인했을 때 같다면 1 2개를 남기고 나머지를 지운 케이스를 고른다

		else {
			sort(v.begin(), v.end(), greater<>());
			// 작은 케이스
			long long small = (1ll << v[0]) + (1ll << v[1]);

			// 큰 케이스
			long long big = (1ll << v[0]) + (1ll << (v[1] + 1ll));

			if (abs(m - small) > abs(m - big)) cout << v[1] + 1 << " " << v[0];
			else cout << v[1] << " " << v[0];
		}

		cout << '\n';
	}

	return 0;
}
