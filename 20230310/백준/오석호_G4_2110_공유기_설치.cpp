#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 2110 공유기 설치
	// 이분 탐색
	int n, c, x;
	vector<int> v;
	cin >> n >> c;
	for (int i = 0; i < n; ++i) {
		cin >> x;
		v.push_back(x);
	}
	
	// 정렬
	sort(v.begin(), v.end());

	// 이분탐색 최대최소 설정
	int s = 1;
	int e = v[n - 1] - v[0]; // 맨 끝에서 맨 앞 뺀거
	int ans = 0;
	
	while (s <= e) {
		int mid = (s + e) / 2; // 최대 거리 계산을 위한 s값과 e값의 평균 처리
		int cnt = 1; // 맨 앞은 무조건 박고 시작해야함 (안박고 더 큰 값을 가지는 경우는 없기 때문)
		int pos = v[0]; // 비교 대상 위치
		for (int i = 1; i < n; ++i) {
			if (v[i] - pos >= mid) {
				++cnt;
				pos = v[i];
			}
		}
		if (cnt >= c) {
			ans = max(ans, mid);
			s = mid + 1;
		}
		else {
			e = mid - 1;
		}
	}
	cout << ans;

	return 0;
}
