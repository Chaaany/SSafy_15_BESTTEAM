#include <iostream>
using namespace std;

// 상하좌우 순서
int dr[] = { 0, -1, 1, 0, 0 };
int dc[] = { 0, 0, 0, -1, 1 };
bool arr[1001][1001];
int order[4];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(NULL);

	// 13091 로봇
	// 구현
	int r, c, k, br, bc, sr, sc, input;

	// 초기값
	cin >> r >> c >> k;

	// 장애물
	for (int i = 0; i < k; ++i) {
		cin >> br >> bc;
		arr[br][bc] = true;
	}

	// 시작위치
	cin >> sr >> sc;
	arr[sr][sc] = true;

	// 이동방향 순서
	for (int i = 0; i < 4;++i) cin >> order[i];

	// 이동
	int tmp = 0;
	while (1) {
		// 4군데 전부 이동 불가면 멈추기
		bool chk = false;
		for (int i = 1; i <= 4; ++i) {
			int rr = sr + dr[i];
			int cc = sc + dc[i];
			if (rr >= 0 && cc >= 0 && rr < r && cc < c && !arr[rr][cc]) chk = true;
		}
		if (!chk) break;

		while (1) {
			sr += dr[order[tmp]];
			sc += dc[order[tmp]];
			// 더이상 못가면 스탑
			if (sr < 0 || sr >= r || sc < 0 || sc >= c || arr[sr][sc]) break;
			arr[sr][sc] = true;
		}
		// sr이랑 sc는 못가는 케이스에서도 한번씩 더 갔을테니 다시 빼줌
		sr -= dr[order[tmp]];
		sc -= dc[order[tmp]];
		tmp = (tmp + 1) % 4;
	}

	cout << sr << " " << sc;

	return 0;
}
