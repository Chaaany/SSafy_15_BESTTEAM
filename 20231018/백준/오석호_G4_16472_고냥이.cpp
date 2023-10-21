#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 16472 고냥이
	// 투포인터
	int n;
	string s;
	int alpha[26] = { 0 };
	cin >> n >> s;
	
	int sidx = 0;
	int ans = 0;
	for (int eidx = 0; eidx < s.size(); ++eidx) {
		// eidx에 해당하는 인덱스의 숫자를 올려주기
		++alpha[s[eidx] - 'a'];
		
		// 사용한 알파벳이 n개를 넘었는지 확인
		while (1) {
			int cnt = 0;
			for (int i = 0; i < 26; ++i) if (alpha[i]) ++cnt;
			if (cnt > n) {
				ans = max(ans, eidx - sidx);
				--alpha[s[sidx] - 'a'];
				++sidx;
			} else {
				break;
			}
		}
	}
	
	// 마무리
	ans = max(ans, (int)s.size() - sidx);
	cout << ans;

	return 0;
}
