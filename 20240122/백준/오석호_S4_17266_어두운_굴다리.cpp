#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 17266 어두운 굴다리
	// 구현
	int n, m;
	int p[100001] = { 0 };
	cin >> n >> m;
	for (int i = 0; i < m; ++i) cin >> p[i];

	// 3가지 조건을 만족해야한다
	// 맨 앞부터 첫번째 가로등까지의 거리
	// 마지막 가로등부터 맨 끝까지의 거리
	// 가로등 사이의 거리 / 2 (올림해야함)
	// 셋 중 가장 큰 친구를 출력해주면 될듯?

	// 1, 2 조건
	int a = max(p[0], n - p[m - 1]);
	// 3조건
	int b = 0;
	for (int i = 1; i < m; ++i) {
		if (ceil(((double)p[i] - (double)p[i - 1]) / 2) > b) b = ceil(((double)p[i] - (double)p[i - 1]) / 2);
	}

	cout << max(a, b);

	return 0;
}
