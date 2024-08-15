#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 2980 도로와 신호등
	// 수학
	int n, l; // 신호등 개수, 신호등 길이
	int ans = 1; // 걸리는 시간 (d가 l보다 크니까 1부터 시작)
	int arr[100][3] = { 0 }; // 신호등마다 신호등의 위치, 신호 빨간불, 초록불 지속시간을 담은 배열
	cin >> n >> l;
	for (int i = 0; i < n; ++i) cin >> arr[i][0] >> arr[i][1] >> arr[i][2];

	// 도로의 길이만큼 돌려서 끝까지 갈 때까지 계산
	for (int i = 1; i <= l; ++i) {
		// 모든 신호등에 대해 계산
		for (int j = 0; j < n; ++j) {
			// 일단 신호등 위치에 도달했고, 현재 시간이 빨간불 시간이라면
			if (i == arr[j][0] && arr[j][1] > ans % (arr[j][1] + arr[j][2])) {
				// 빨간불이 끝나는 시점까지 시간을 더해준다
				ans += arr[j][1] - ans % (arr[j][1] + arr[j][2]);
			}
		}
		// 마지막이 아니라면 다음칸으로 넘어가야 하니까 1을 더해준다
		if (i != l) ++ans;
	}

	cout << ans;

	return 0;
}
