#include <iostream>
using namespace std;

int r[6][3]; // 플레이어별 승무패
pair<int, int> game[15]; // 경기대상

bool dfs(int n) {
	// 0으로 만들면 다 처리한거
	if (n == 15) {
		for (int i = 0; i < 6; ++i) {
			for (int j = 0; j < 3; ++j) {
				if (r[i][j]) return false;
			}
		}
		return true;
	}

	// 게임처리
	int home = game[n].first;
	int away = game[n].second;

	// 홈팀 승리
	if (r[home][0] && r[away][2]) {
		--r[home][0];
		--r[away][2];
		if (dfs(n + 1)) return true;
		++r[home][0];
		++r[away][2];
	}

	// 어웨이팀 승리
	if (r[home][2] && r[away][0]) {
		--r[home][2];
		--r[away][0];
		if (dfs(n + 1)) return true;
		++r[home][2];
		++r[away][0];
	}

	// 무재배
	if (r[home][1] && r[away][1]) {
		--r[home][1];
		--r[away][1];
		if (dfs(n + 1)) return true;
		++r[home][1];
		++r[away][1];
	}

	return false;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 6987 월드컵
	// 브루트포스
	
	// 게임셋 짜기
	int tmp = 0;
	for (int i = 0; i < 6; ++i) {
		for (int j = i + 1; j < 6; ++j) {
			game[tmp] = make_pair(i, j);
			++tmp;
		}
	}
	
	for (int i = 0; i < 4; ++i) {
		// 입력
		for (int j = 0; j < 6; ++j) {
			for (int k = 0; k < 3; ++k) cin >> r[j][k];
		}

		cout << dfs(0) << " ";
	}

	return 0;
}
