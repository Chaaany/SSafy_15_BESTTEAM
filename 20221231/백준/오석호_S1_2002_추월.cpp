#include <iostream>
#include <string>
#include <map>
#include <vector>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 2002 추월
	// 문자열
	map<string, int> m;
	vector<string> v;
	string s;
	int n;
	int ans = 0;
	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> s;
		v.push_back(s);
		
	}
	for (int i = 0; i < n; ++i) {
		cin >> s;
		m[s] = i;
	}

	// 내 앞의 차 중에 없어진게 있으면 안된다
	for (int i = 1; i < n; ++i) {
		for (int j = 0; j < i; ++j) {
			if (m[v[j]] > m[v[i]]) {
				++ans;
				break;
			}
		}
	}

	cout << ans;

	return 0;
}    
