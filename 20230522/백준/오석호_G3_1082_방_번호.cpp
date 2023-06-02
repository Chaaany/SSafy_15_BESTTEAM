#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1082 방 번호
	// 그리디
	int n, p, m;
	int arr[10];
	int ans[50] = { 0 };
	cin >> n;

	// 싼 수 구하기
	int min1 = 51;
	int min1Idx = 0;
	int min2 = 51;
	int min2Idx = 0;
	for (int i = 0; i < n; ++i) {
		cin >> arr[i];
		if (i == 0) {
			min1 = arr[i];
			min1Idx = i;
		}
		else {
			if (arr[i] <= min1) {
				min2 = min1;
				min2Idx = min1Idx;
				min1 = arr[i];
				min1Idx = i;
			}
			else if (arr[i] <= min2) {
				min2 = arr[i];
				min2Idx = i;
			}
		}
	}
	cin >> m;

	// 살 수 있는 방 번호가 없는 경우
	if (m < min1) {
		cout << "0";
		return 0;
	}

	// 자리수를 늘릴 수 있는 대로 늘린다
	int cnt = 0;
	if (min1Idx == 0) {
		ans[cnt] = min2Idx;
		++cnt;
		m -= min2;
	}
	while (m >= min1) {
		ans[cnt] = min1Idx;
		++cnt;
		m -= min1;
	}

	// 앞에서부터 더 큰 수로 바꿀 수 있으면 바꿔준다
	for (int i = 0; i < cnt; ++i) {
		for (int j = n - 1; j >= 0; --j) {
			if (m >= arr[j] - arr[ans[i]]) {
				m -= arr[j] - arr[ans[i]];
				ans[i] = j;
				break;
			}
		}
	}

	// 정답 출력
	for (int i = 0; i < cnt; ++i) {
		cout << ans[i];
	}

	return 0;
}
