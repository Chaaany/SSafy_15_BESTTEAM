#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);	
	cout.tie(NULL);

	// 1421 나무꾼 이다솜
	// 브루트포스
	long long n, c, w;
	long long arr[50] = { 0 };
	vector<long long> v;
	cin >> n >> c >> w;
	// 나무 받기
	for (int i = 0; i < n; ++i) cin >> arr[i];
	// 나무 정렬하기
	sort(arr, arr + n);

	for (long long i = 1; i <= arr[n - 1]; ++i) {
		long long cutCntTotal = 0;
		long long woodCntTotal = 0;
		// 나무 다 자르기
		for (int j = 0; j < n; ++j) {
			long long cutCnt, woodCnt;
			if (arr[j] % i == 0) cutCnt = arr[j] / i - 1;
			else cutCnt = arr[j] / i;
			woodCnt = arr[j] / i;
			// 자르는 비용이 더 큰 케이스는 배제한다
			if (woodCnt * w * i - cutCnt * c > 0) {
				cutCntTotal += cutCnt;
				woodCntTotal += woodCnt;
			}
		}
		v.push_back(i * woodCntTotal * w - cutCntTotal * c);
	}
	// 정렬해서 가장 큰 이득만 뽑아내기
	sort(v.begin(), v.end(), greater<>());
	if (v[0] > 0) cout << v[0];
	else cout << 0;

	return 0;
}
