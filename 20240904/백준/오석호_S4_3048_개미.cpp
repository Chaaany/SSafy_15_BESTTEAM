#include <iostream>
#include <vector>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 3048 개미
	// 구현, 시뮬레이션
	int n1, n2, t;
	string s;
	vector<pair<char, int> > v; // int값에 따라 좌우 구분
	cin >> n1 >> n2;

	// 우로 이동 (순서 거꾸로)
	cin >> s;
	for (int i = n1 - 1; i >= 0; --i) v.push_back(make_pair(s[i], 0));

	// 좌로 이동
	cin >> s;
	for (int i = 0; i < n2; ++i) v.push_back(make_pair(s[i], 1));

	// 시간의 흐름에 따라 이동
	cin >> t;
	int cnt = 0;
	while (cnt != t) {
		for (int i = 0; i < n1 + n2 - 1; ++i) {
			// 내 앞에 반대방향으로 움직이는 개미가 있으면 점프
			if (v[i].second == 0 && v[i + 1].second == 1) {
				swap(v[i], v[i + 1]);
				++i; // 앞에 안봐도 되니까 바로 다음으로
			}
		}
		++cnt;
	}

	for (int i = 0; i < n1 + n2; ++i) cout << v[i].first;

	return 0;
}
