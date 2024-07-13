#include <iostream>
#include <string>
#include <map>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 7785 회사에 있는 사람
	// map
	int n;
	string s1, s2;
	map<string, string, greater<string>> m;
	
	cin >> n;

	for (int i = 0; i < n; ++i) {
		cin >> s1 >> s2;
		if (s2 == "enter") m.insert(make_pair(s1, s2));
		else m.erase(s1);
	}

	// 사전순의 역순으로 출력
	for (auto elem : m) cout << elem.first << '\n';
	
	return 0;
}
