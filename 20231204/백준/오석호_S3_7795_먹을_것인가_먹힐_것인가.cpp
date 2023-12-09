#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 7795 먹을 것인가 먹힐 것인가
	// 투포인터
	int t, n, m, input;
	
	cin >> t;
	while (t--) {
		vector<int> a, b;
		cin >> n >> m;
		for (int i = 0; i < n; ++i) {
			cin >> input;
			a.push_back(input);
		}
		for (int i = 0; i < m; ++i) {
			cin >> input;
			b.push_back(input);
		}

		// 정렬
		sort(a.begin(), a.end());
		sort(b.begin(), b.end());

		int ans = 0; // 쌍의 수
		int bIdx = 0; // b의 인덱스 (a의 인덱스는 i)
		// a를 한칸씩 올려가면서 b가 몇개인지 계속 ans에 더해주는 방식
		for (int i = 0; i < n; ++i) {
			while (bIdx < m && a[i] > b[bIdx]) ++bIdx;
			ans += bIdx;
		}
		cout << ans << '\n';
	}

	return 0;
}
