#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 17204 죽음의 게임
	// 구현
	int n, k;
	int ans = 0; // 말해야하는 가장 작은 정수
	int arr[151] = { 0 }; // 지목한 사람 배열
	bool chk[151] = { 0 }; // 현재 지목 당했는지 여부를 나타내는 배열
	cin >> n >> k;
	
	// 입력
	for (int i = 0; i < n; ++i) cin >> arr[i];
	
	// 영기가 지목한 사람으로 최초 타겟을 지정
	int target = arr[0];
	
	// 누군가 걸릴 때까지 무한루프
	while (!chk[target]) {
		++ans; // 지목 횟수 (최초에 영기가 지목해야하니까 바로 ans를 올려야한다)
		chk[target] = true; // 지목당했다면 그사람 체크
		if (target == k) { // 마지막에 보성이가 지목당한다면 목표 달성
			cout << ans;
			return 0;
		}
		target = arr[target]; // 타겟 바꾸기
	}

	// 만약 보성이가 지목당하지 않고 끝나면 -1 출력
	cout << -1;

	return 0;
}
