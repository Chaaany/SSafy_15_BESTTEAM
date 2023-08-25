#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
#include <set>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1235 학생 번호
	// 문자열
	vector<string> v;
	int n;
	string s;
	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> s;
		reverse(s.begin(), s.end()); // 뒷자리부터 써먹어야하니까 뒤집어서 넣기
		v.push_back(s);
	}
	
	// k값을 증가시켜나가면서 확인하기
	int k = 1;
	while (1) {
		set<string> ss;
		for (int i = 0; i < v.size(); ++i) ss.insert(v[i].substr(0, k));
		if (v.size() == ss.size()) break;
		else ++k;
	}

	cout << k;

	return 0;
}
