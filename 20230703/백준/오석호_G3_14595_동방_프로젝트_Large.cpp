#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 14595 동방 프로젝트(Large)
	// 구현
	int n, m, x, y;
	cin >> n >> m;
	int ans = 0;

	// 허무는 벽 담는 vector
	vector<pair<int, int>> v;
	
	// 입력
	for (int i = 0; i < m; ++i) {
		cin >> x >> y;
		v.push_back(make_pair(x, y));
	}

	// 어짜피 언제 방을 합쳐도 같기 때문에 걍 정렬해준다
	sort(v.begin(), v.end());
	
	// 벽뿌
	int s = 0;
	int e = 0;
	for (int i = 0; i < m; ++i) {
		if (v[i].first > e) {
			// 마지막으로 건드린 방보다 새롭게 뿌수기 시작하는 방이 더 뒤에 있다면 그만큼 새로운 방을 추가
			ans += (v[i].first - e);
			// start값 갱신
			s = v[i].first;
		}
		// end값 갱신
		if (e < v[i].second) e = v[i].second;
	}
	// 처리 안된 친구들 처리
	ans += n - e;

	// 출력
	cout << ans;

	return 0;
}
