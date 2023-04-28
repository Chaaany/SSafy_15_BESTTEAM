#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);	
	cout.tie(NULL);

	// 2785 체인
	// 그리디
	int n, input;
	int ans = 0;
	vector<int> v;
	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> input;
		v.push_back(input);
	}
	// 순서대로 정렬
	sort(v.begin(), v.end());

	// 1개가 남을 때까지 연결
	while (v.size() > 1) {
		// 제일 작은 크기의 고리를 사용해서 고리 합치기
		v[v.size() - 2] += v[v.size() - 1] + 1;
		v.pop_back();
		++ans;
		--v[0];

		// v[0]이 0이 될 때 처리
		if (!v[0]) v.erase(v.begin());
	}
	cout << ans;

	return 0;
}
