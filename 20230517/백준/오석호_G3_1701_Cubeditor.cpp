#include <iostream>
#include <vector>
#include <string>
using namespace std;

// 접두사의 최대 길이 값을 구하는 kmp
vector<int> kmp(string s) {
	vector<int> ans(s.size());
	int idx = 0;
	for (int i = 1; i < s.size(); ++i) {
		// idx가 0이 아닌 경우 처리
		while (idx > 0 && s[i] != s[idx]) idx = ans[idx - 1];
		// idx가 0인 경우 처리
		if (s[i] == s[idx]) ans[i] = ++idx;
		else ans[i] = 0;
	}
	return ans;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1701 Cubeditor
	// 문자열
	string s;
	int ans = 0;
	cin >> s;
	for (int i = 0; i < s.size(); ++i) {
		string tmp = s.substr(i, s.size() - i); // 앞에서부터 i만큼 자르기
		vector<int> v = kmp(tmp); // kmp 구하기
		// 최댓값 갱신
		for (int j = 0; j < s.size() - i; ++j) if (ans < v[j]) ans = v[j];
	}

	cout << ans;
		
	return 0;
}
