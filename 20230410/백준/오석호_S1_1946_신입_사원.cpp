#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1946 신입 사원
	// 그리디
	int t, n, a, b;
	cin >> t;
	while (t--) {
		cin >> n;
		vector<pair<int, int>> v;
		int ans = 1; // 첫 사람, 즉 최소 1명은 붙으니까

		// 입력값 받기
		for (int i = 0; i < n; ++i) {
			cin >> a >> b;
			v.push_back(make_pair(a, b));
		}

		// 서류 성적 기준으로 정렬
		sort(v.begin(), v.end());

		// 면접 성적 저장
		int interview = v[0].second;

		// 면접성적이 더 좋은 (랭크값이 낮은) 친구가 있으면 ans에 1 더하고 interview를 갱신
		for (int i = 1; i < n; ++i) {
			if (v[i].second < interview) {
				++ans;
				interview = v[i].second;
			}
		}
		
		// 출력
		cout << ans << '\n';
	}

	return 0;
}
