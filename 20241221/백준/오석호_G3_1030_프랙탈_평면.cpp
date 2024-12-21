#include <iostream>
#include <cmath>
using namespace std;

int s, n, k, r1, r2, c1, c2; // 시간, 제곱 길이, 내부 검은색 길이, 출력해야하는 부분(r1~r2, c1~c2)

// 시간과 좌표값을 받아서 재귀를 돌려서 해당 좌표의 값이 t시간에 검은색인지 흰색인지 출력하는 함수
int getFractal(int size, int r, int c) {
	// size가 1이면 흰색
	if (size == 1) return 0;
	// 몇 번째 프랙탈 위치에 있는지
	int pos = size / n;
	// 검은영역안에 들어가는지 체크
	if (r >= pos * (n - k) / 2 && r < pos * (n + k) / 2 && c >= pos * (n - k) / 2 && c < pos * (n + k) / 2) return 1;

	return getFractal(pos, r % pos, c % pos);
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1030 프랙탈 평면
	// 재귀
	cin >> s >> n >> k >> r1 >> r2 >> c1 >> c2;

	// 좌표를 넣고 프랙탈 내에서 어떤 위치에 있는지를 판단하는 getFractal()의 값을 출력한다.
	for (int i = r1; i <= r2; ++i) {
		for (int j = c1; j <= c2; ++j) {
			cout << getFractal(pow(n, s), i, j);
		}
		cout << '\n';
	}

	return 0;
}
