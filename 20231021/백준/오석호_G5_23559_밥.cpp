#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 23559 밥
	// 그리디
	int n, x, a, b;
	int mat[100001] = { 0 }; // 맛 차이들
	int ans = 0; // 맛의 최대값
	cin >> n >> x;

	for (int i = 0; i < n; ++i) {
		cin >> a >> b;
		mat[i] = a - b;
		// 우선 1000원짜리 선택한다고 가정
		ans += b; 
		x -= 1000;
	}

	// 맛차이 내림차순 정렬
	sort(mat, mat + n, greater<>());

	for (int i = 0; i < n; ++i) {
		// 5000원짜리가 더 이득이면 바꿔주기
		if (x >= 4000 && mat[i] > 0) {
			x -= 4000;
			ans += mat[i];
		}
	}

	cout << ans;

	return 0;
}
