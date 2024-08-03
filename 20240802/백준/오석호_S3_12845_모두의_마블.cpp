#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 12845 모두의 마블
	// 그리디
	int n;
	int arr[1000] = { 0 };
	cin >> n;

	int maxValue = -1;
	int maxIdx = 0;

	// 제일 높은 레벨 찾기
	for (int i = 0; i < n; ++i) {
		cin >> arr[i];
		if (maxValue < arr[i]) {
			maxValue = arr[i];
			maxIdx = i;
		}
	}

	// 제일 높은 레벨을 카드 A로 두고 나머지 요소들을 전부 합성했을 때가 최대
	int ans = 0;
	for (int i = 0; i < maxIdx; ++i) ans += arr[i] + arr[maxIdx];
	for (int i = maxIdx + 1; i < n; ++i) ans += arr[i] + arr[maxIdx];

	cout << ans;

	return 0;
}
