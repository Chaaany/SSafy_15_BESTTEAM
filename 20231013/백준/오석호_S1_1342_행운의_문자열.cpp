#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

// 인접한게 같은지 확인하는 chk 함수
bool chk(string s) {
	for (int i = 0; i < s.size() - 1; ++i) {
		if (s[i] == s[i + 1]) return false;
	}
	return true;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1342 행운의 문자열
	// 문자열
	string s;
	int ans = 0;
	cin >> s;
	sort(s.begin(), s.end());
	// 1차 테스트
	if (chk(s)) ++ans;
	// 나머지는 순열 돌려가며 모든 경우의 수 확인
	while (next_permutation(s.begin(), s.end())) {
		if (chk(s)) ++ans;
	}
	cout << ans;

	return 0;
}
