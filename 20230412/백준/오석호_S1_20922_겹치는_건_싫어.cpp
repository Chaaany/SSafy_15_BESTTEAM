#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 20922 겹치는 건 싫어
	// 투포인터
	int n, k;
	cin >> n >> k;

	int num[200001] = { 0 }; // 입력값
	int cnt[100001] = { 0 }; // 한 정수의 개수
	int ans = 0; // 정답

	// 입력받기
	for (int i = 0; i < n; ++i) {
		cin >> num[i];
	}

	// 부분수열 처음과 끝
	int s = 0;
	int e = 0;
	while (s <= e && e < n) {
		while (e < n) {
			// 이미 k개의 정수를 포함했다면 break;
			if (cnt[num[e]] == k) break;
			// 계속 하나식 더해나가면서 숫자 세기
			++cnt[num[e++]];
		}
		// 정답 갱신
		ans = max(ans, e - s);
		// k개가 존재하는 원소가 나올 떄까지 s를 증가시킴 (그걸 빼야 뒤에 더 넣을 수 있을테니까)
		bool chk = true;
		while (s < e && chk) {
			if (cnt[num[s]] == k) chk = false;
			--cnt[num[s++]];
		}
	}
	// 정답 출력
	cout << ans;

	return 0;
}
