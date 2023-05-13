#include <iostream>
#include <string>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1522 문자열 교환
	// 브루트포스
	string s;
	int aCnt = 0;
	int ans = 1000;
	cin >> s;
	// a 개수 찾기
	for (int i = 0; i < s.size(); ++i) if (s[i] == 'a') ++aCnt;
	// string에 a 개수만큼 더해주기
	for (int i = 0; i < aCnt; ++i) s += s[i];
	// s에서 a개수만큼 잘라서 확인했을 때 해당 구간에 속한 b의 값이 가장 적을 때가 정답
	for (int i = 0; i < s.size() - aCnt; ++i) {
		int tmp = 0;
		for (int j = i; j < i + aCnt; ++j) {
			if (s[j] == 'b') ++tmp;
		}
		if (ans > tmp) ans = tmp;
	}
	cout << ans;

	return 0;
}
