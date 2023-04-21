#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);	
	cout.tie(NULL);

	// 20006 랭킹전 대기열
	// 구현
	int p, m, l;
	string n;
	vector<pair<string, int>> v[301];
	int roomCnt = 0;
	cin >> p >> m;
	for (int i = 0; i < p; ++i) {
		cin >> l >> n;
		bool chk = true; // 새로운 방을 팠는지 확인
		for (int j = 0; j < roomCnt; ++j) {
			if (v[j].size() < m && v[j][0].second - l <= 10 && v[j][0].second - l >= -10) {
				chk = false;
				v[j].push_back(make_pair(n, l));
				break;
			}
		}
		if (chk) v[roomCnt++].push_back(make_pair(n, l));
	}

	for (int i = 0; i < roomCnt; ++i) {
		if (v[i].size() == m) cout << "Started!\n";
		else cout << "Waiting!\n";
		sort(v[i].begin(), v[i].end());// 정렬
		for (int j = 0; j < v[i].size(); ++j) cout << v[i][j].second << " " << v[i][j].first << '\n';
	}
	
	return 0;
}
