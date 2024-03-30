#include <iostream>
#include <cmath>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(NULL);

	// 1069 집으로
	// 기하학
	int x, y, d, t;
	cin >> x >> y >> d >> t;

	double dist = sqrt(x * x + y * y);
	double ans = 2000;
	int jump = dist / d; // (0,0)쪽으로의 점프 횟수
	double left = dist - jump * d; // 넘어가지 않는 선에서 걸어가야 하는 남은 거리
	// 점프하고 남은 거리 걷는 경우
	ans = min(dist, jump * t + left);
	// 0,0 넘어서 점프 후 돌아가는 경우
	ans = min(ans, (jump + 1) * t + (jump + 1) * d - dist);
	// 점프로 바로 끝내는 경우 (살짝 각도를 꺾는 케이스)
	if (jump > 0) ans = min(ans, (double)(jump + 1) * t);
	// 점프 2번으로 끝내는 경우 (살짝 각도를 꺾는 케이스, 예제 6)
	else {
		if (dist < d) ans = min(ans, t * 2.0);
	}

	cout << fixed;
	cout.precision(9);
	cout << ans;

	return 0;
}
