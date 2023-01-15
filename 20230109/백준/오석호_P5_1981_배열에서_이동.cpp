#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int dr[4] = { 0, 1, 0, -1 };
int dc[4] = { 1, 0, -1, 0 };

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1981 배열에서 이동
	// 투포인터
	int n;
	int arr[100][100] = { 0 };
	cin >> n;
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			cin >> arr[i][j];
		}
	}

	int s = 0;
	int e = arr[0][0];
	int ans = 200;

	while (s <= 200 && e <= 200) {
		bool chk = false;
		queue<pair<int, int>> q;
		bool checked[100][100] = { 0 };
		q.push(make_pair(0, 0));
		if (arr[0][0] < s || arr[0][0] > e) {
			++e;
			continue;
		}
		while (!q.empty()) {
			int r = q.front().first;
			int c = q.front().second;
			q.pop();
			if (r == n - 1 && c == n - 1) {
				chk = true;
				break;
			}
			for (int i = 0; i < 4; ++i) {
				int rr = r + dr[i];
				int cc = c + dc[i];
				if (rr >= 0 && rr < n && cc >= 0 && cc < n && !checked[rr][cc] && arr[rr][cc] >= s && arr[rr][cc] <= e) {
					q.push(make_pair(rr, cc));
					checked[rr][cc] = true;
				}
			}
		}
		if (chk) {
			ans = min(ans, e - s);
			++s;
		}
		else ++e;
	}

	cout << ans;

	return 0;
}
