#include <iostream>
#include <unordered_set>
#include <string>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);	
	cout.tie(NULL);

	// 22233 가희와 키워드
	// 문자열
	int n, m;
	string s;
	unordered_set<string> us;
	cin >> n >> m;
	for (int i = 0; i < n; ++i) {
		cin >> s;
		us.insert(s);
	}
	while (m--) {
		string s2, tmp;
		cin >> s2;
		int idx = 0;
		while (idx < s2.size()) {
			auto it = s2.find(',', idx);
			if (it == s2.npos) {
				tmp = s2.substr(idx);
				if (us.find(tmp) != us.end()) us.erase(tmp);
				break;
			}
			else {
				tmp = s2.substr(idx, it - idx);
				if (us.find(tmp) != us.end()) us.erase(tmp);
				idx = it + 1;
			}
		}
		cout << us.size() << '\n';
	}

	return 0;
}
