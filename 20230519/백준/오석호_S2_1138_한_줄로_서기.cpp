#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1138 한 줄로 서기
	// 그리디
	int n;
	int arr[11] = { 0 }; // 입력배열
	int ans[11] = { 0 }; // 정답배열
	cin >> n;
	for (int i = 0; i < n; ++i) cin >> arr[i];
	for (int i = 0; i < n; ++i) {
		int cnt = 0;
		// 작은 키인 사람부터 순서대로 arr에 위치하기 떄문에 그리디 형태로 넣어주면 끝
		for (int j = 0; j < n; ++j) {
			if (arr[i] == cnt && !ans[j]) {
				ans[j] = i + 1;
				break;
			}
			else {
				if (!ans[j]) ++cnt;
			}
		}
	}
	// 출력
	for (int i = 0; i < n; ++i) cout << ans[i] << " ";
		
	return 0;
}
