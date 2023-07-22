#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 22353 헤이카카오
	// 수학
	double a, d, k; // 한판당 시간, 이길 확률, 승률 상승 비율
	double lose = 1; // 지금까지 모든 경기를 질 확률
	double ans = 0; // 답
	cin >> a >> d >> k;
	// 백분율처리
	d /= 100;
	k /= 100;
	
	// 무한계산
	int cnt = 1;
	while (1) {
		ans += cnt * a * lose * d; // 지금까지 다 졌는데 이번판에서 이겼을 때의 기댓값 더하기
		if (d == 1) break; // 승리 확률이 100%인 상태면 더 처리할 필요가 없다
		++cnt; // 반복 횟수 증가
		lose = lose * (1 - d); // 모든 경기를 질 확률 처리
		d += d * k; // 빅데이터에 기반한 승리 확률 증가 처리
		if (d > 1) d = 1; // 승리 확률이 100%가 넘을 순 없으니까
	}
	cout.precision(7);
	cout << fixed << ans;

	return 0;
}
