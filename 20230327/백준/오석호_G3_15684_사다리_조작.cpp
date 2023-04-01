#include <iostream>
using namespace std;

// 전역에 값 저장해두기 (아래 함수에서 사용하기 위해)
int n, m, h; // n 세로선, m 가로선, h는 세로선마다 가로선을 넣을 수 있는 위치의 개수
int ans = 301; // 첫 시작값이 30 * 10보다는 커야하니까
bool ladder[31][11]; // 연결된 가로선을 담은 이차원 배열, 앞은 가로줄의 높이, 뒤는 세로줄의 시작번호

bool test() {
	// 1부터 끝까지 내려가며 자기 자신을 가리키는지 테스트
	// 세로선 먼저
	for (int i = 1; i <= n; ++i) {
		int pos = i; // 내려가는 과정에서 위치를 저장하는 값, 최초에는 자기 자신 위치에 있을테니 i 저장
		for (int j = 1; j <= h; ++j) {
			// 자기보다 큰 이름의 세로선부터 가로선이 나 있는 경우
			if (ladder[j][pos]) ++pos;
			// 자기보다 작은 이름의 세로선으로 가로선이 나 있는 경우
			else if (ladder[j][pos - 1]) --pos;
		}
		// 마지막
		if (pos != i) return false;
	}
	return true;
}
void dfs(int maxCnt, int cnt) {
	if (maxCnt == cnt) {
		if (test()) ans = maxCnt;
		return;
	}
	
	// 세로줄
	for (int i = 1; i < n; ++i) {
		// 가로줄
		for (int j = 1; j <= h; ++j) {
			// 자기자신, 앞, 뒤 세로줄에는 해당 i높이에 가로선을 그을 수 없다
			if (ladder[j][i] || ladder[j][i - 1] || ladder[j][i + 1]) continue;
			// 백트래킹
			ladder[j][i] = true;
			dfs(maxCnt, cnt + 1);
			ladder[j][i] = false;
			while (!ladder[j][i - 1] && !ladder[j][i + 1]) ++j; // 이미 놓았다면 불필요한 체크 방지
		}
	}
	return;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 15684 사다리 조작
	// 백트래킹

	// n 세로선, m 가로선, h는 세로선마다 가로선을 넣을 수 있는 위치의 개수
	cin >> n >> m >> h;

	// 입력받기
	for (int i = 0; i < m; ++i) {
		int row, col;
		cin >> row >> col;
		// 입력값 받아서 ladder에 넣기
		ladder[row][col] = true;
	}

	// 백트래킹
	for (int i = 0; i < 4; ++i) {
		if (ans == 301) dfs(i, 0);
	}
	
	// 예외처리
	if (ans == 301) ans = -1;

	// 출력
	cout << ans;

	return 0;
}
