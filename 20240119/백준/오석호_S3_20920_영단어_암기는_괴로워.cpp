#include <iostream>
#include <string>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;

bool cmp(pair<string, int> a, pair<string, int> b) {
	if (a.second == b.second) {
		if (a.first.size() == b.first.size()) return a.first < b.first;
		return a.first.size() > b.first.size();
	}
	
	return a.second > b.second;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 20920 영단어 암기는 괴로워
	// 해시
	int n, m;
	string s;
	map<string, int> mm;
	vector<pair<string, int>> v;
	cin >> n >> m;

	for (int i = 0; i < n; ++i) {
		cin >> s;
		if (s.size() >= m) ++mm[s];
	}

	for (auto &i : mm) v.push_back(make_pair(i.first, i.second));

	sort(v.begin(), v.end(), cmp);

	for (auto &i : v) cout << i.first << '\n';

	return 0;
}
