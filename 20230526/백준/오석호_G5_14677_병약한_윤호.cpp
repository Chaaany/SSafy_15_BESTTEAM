#include <iostream>
#include <string>
#include <queue>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 14677 병약한 윤호
	// BFS
	int n;
	string s;
	cin >> n >> s;

	int ans = 0;
	int cnt = 0; // 시간 확인용 (0 아침 1 점심 2 저녁)
	bool chk[1501][1501] = { 0 }; // 중복체크 제거용
	queue<pair<int, int>> q; // 남은 문자열 범위를 담음
	q.push(make_pair(0, n * 3 - 1));
	chk[0][n * 3 - 1] = true;
	while (!q.empty()) {
		int tmp = q.size(); // 이전 턴에 큐에 들어간 요소들을 모두 사용하기 위해서 따로 체크 (그래야 정상적으로 cnt 체크 가능)
		for (int i = 0; i < tmp; ++i) {
			int l = q.front().first;
			int r = q.front().second;
			q.pop();
			// l > r이 되는 경우 더이상 먹을 약이 없는 경우이므로 체크할 필요가 없음
			if (l > r) break;
			// 왼쪽에서 약먹는 경우
			if (((s[l] == 'B' && cnt == 0) || (s[l] == 'L' && cnt == 1) || (s[l] == 'D' && cnt == 2)) && !chk[l + 1][r]) {
				chk[l + 1][r] = true;
				q.push(make_pair(l + 1, r));
				ans = max(ans, n * 3 - (r - l));
			}
			// 오른쪽에서 약먹는 경우
			if (((s[r] == 'B' && cnt == 0) || (s[r] == 'L' && cnt == 1) || (s[r] == 'D' && cnt == 2)) && !chk[l][r - 1]) {
				chk[l][r - 1] = true;
				q.push(make_pair(l, r - 1));
				ans = max(ans, n * 3 - (r - l));
			}
		}
		cnt = ++cnt % 3;
	}
	cout << ans;

	return 0;
}
