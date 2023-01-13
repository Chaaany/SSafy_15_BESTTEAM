#include <iostream>
using namespace std;

long long sumFromOne(long long n) {
	// n레벨이 되기 위해서는 1부터 n-1까지의 합만큼의 성향아이템이 필요하다
	return n * (n - 1) / (long long)2;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 26645 성장의 비약 선택권
	// 이분탐색, 매개변수탐색
	long long n;
	long long m;
	long long ans = -1;
	long long arr[100000] = { 0 };
	long long canLevel[100000] = { 0 };
	long long items[100000] = { 0 };
	cin >> n >> m;
	for (long long i = 0; i < n; ++i) cin >> arr[i];
	for (long long i = 0; i < n; ++i) cin >> items[i];

	// 레벨업 시뮬레이션 해보기
	// 몇레벨까지 올릴 수 있는 지 구해놓으면 좋을거같음
	// 여기서도 이분탐색
	for (long long i = 0; i < n; ++i) {
		long long minLevel = arr[i];
		long long maxLevel = 2147000000;
		while (minLevel <= maxLevel) {
			long long midLevel = (minLevel + maxLevel) / 2;
			bool chk = true; // true면 기준(midLevel)이 더 커도됨, false 면 기준이 더 작아야함
			
			if (sumFromOne(midLevel) - sumFromOne(arr[i]) <= items[i]) {
				canLevel[i] = midLevel;
			}
			else chk = false;

			if (chk) minLevel = midLevel + 1;
			else maxLevel = midLevel - 1;
		}
	}


	// 최소 최대 기준으로 이분탐색하면서 만들 수 있는 레벨 찾기
	long long minLevel = 1;
	long long maxLevel = 1000000000000;
	while (minLevel <= maxLevel) {
		long long midLevel = (minLevel + maxLevel) / 2;
		int chk = 0; // 0이면 정답, 1이면 더 커야함, 2면 더 작아야함
		long long expElixir = m;
		// 전부 돌면서 해당 레벨까지 올라갈 수 있는지 확인
		for (int i = 0; i < n; ++i) {
			// 이미 해당 레벨 넘었으면 바로 끝내기
			if (arr[i] > midLevel) {
				chk = 1;
				break;
			}
			
			if (canLevel[i] < midLevel && canLevel[i] + expElixir >= midLevel && expElixir >= 0) {
				expElixir -= midLevel - canLevel[i];
			}
			else if (canLevel[i] >= midLevel) continue;
			else {
				chk = 2;
				break;
			}
		}

		// 정답 체크
		if (chk == 0) ans = midLevel;

		// 다음 단계로
		if (chk == 0 || chk == 1) minLevel = midLevel + 1;
		else if (chk == 2) maxLevel = midLevel - 1;
	}

	cout << ans;

	return 0;
}
