#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 29155 개발자 지망생 구름이의 취업 뽀개기
	// 정렬
	int n, k, t;
	int arr[5] = { 0 };
	vector<int> v[5];

	cin >> n;

	// 풀어야 하는 문제 수 입력
	for (int i = 0; i < 5; ++i) cin >> arr[i];

	// 난이도와 걸리는 시간 입력
	for (int i = 0; i < n; ++i) {
		cin >> k >> t;
		v[k - 1].push_back(t);
	}

	// 최소시간 구하기 (난이도당 최소 1문제씩은 있으니 난이도를 스킵할 가능성은 0)
	int ans = 0;
	for (int i = 0; i < 5; ++i) {
		sort(v[i].begin(), v[i].end());
		for (int j = 0; j < arr[i]; ++j) {
			ans += v[i][j];
			// 만약 같은 난이도면 두 문제를 푸는데 걸리는 시간의 차이만큼 ans에 더하기
			if (j + 1 != arr[i]) ans += v[i][j + 1] - v[i][j];
		}
		ans += 60;
	}

	// 마지막에도 60이 더해졌으므로 뺀 값을 출력
	cout << ans - 60;

	return 0;
}
