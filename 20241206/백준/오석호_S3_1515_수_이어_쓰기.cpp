#include <iostream>
#include <string>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1515 수 이어 쓰기
	// 문자열
    string s;
    int idx = 0;
    int ans = 1;
    
    cin >> s;

    while (idx != s.length()) {
        string st = to_string(ans);

        for (int i = 0; i < st.length(); ++i) {
            if (s[idx] == st[i]) {
                ++idx;
                if (idx >= s.length()) {
                    cout << ans;
                    return 0;
                }
            }
        }
        ++ans;
    }

	return 0;
}
