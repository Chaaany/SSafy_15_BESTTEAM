#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(NULL);

	// 1377 버블 소트
	// 정렬
	int n, input;
	vector<pair<int, int>> v; // 앞은 값, 뒤는 원래 index값
	int ans = -1;
	cin >> n;
	
	for (int i = 0; i < n; ++i) {
		cin >> input;
		v.push_back(make_pair(input, i));
	}

	sort(v.begin(), v.end());

	// 버블소트는 좌측으로는 한턴에 1칸밖에 못움직이니까 제일 좌측으로 많이 움직인 케이스를 찾아서 출력하면 될듯?
	// 우측 이동은 한턴에 n번까지 가능하니까 좌측만 찾으면 된다
	for (int i = 0; i < n; ++i) {
		if (v[i].second - i > ans) ans = v[i].second - i;
	}

	// 아무것도 안바꿔도 한번은 버블소트 한거니까 +1 해준다
	cout << ans + 1;

	return 0;
}
