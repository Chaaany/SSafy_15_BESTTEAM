#include <iostream>
#include <string>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 2503 숫자 야구
  // 브루트포스
	int n;
	cin >> n;
	int input, strike, ball;
	int ans = 0;
	bool arr[1000] = { 0 };

	// 불가능한거 true로 만들기
	for (int i = 123; i <= 987; ++i) {
		string s = to_string(i);
		if (s[0] == s[1] || s[1] == s[2] || s[2] == s[0]) arr[i] = true;
		else if (s[0] == '0' || s[1] == '0' || s[2] == '0') arr[i] = true;
	}

	// 스트라이크랑 볼 체크
	while (n--) {
		cin >> input >> strike >> ball;
		for (int i = 123; i <= 987; ++i) {
			int sCnt = 0;
			int bCnt = 0;
			if (!arr[i]) {
				string target = to_string(input);
				string tmp = to_string(i);

				for (int j = 0; j < 3; ++j) {
					for (int k = 0; k < 3; ++k) {
						// 자릿수랑 위치가 모두 같으면 스트라이크
						if (j == k && target[j] == tmp[k]) ++sCnt;
						// 자리수는 다른데 그 숫자를 포함했으면 볼
						if (j != k && target[j] == tmp[k]) ++bCnt;
					}
				}

				// 스트라이크와 볼 개수가 예측한대로가 아니라면 true처리
				if (sCnt != strike || bCnt != ball) arr[i] = true;
			}
		}
	}

	for (int i = 123; i <= 987; ++i) if (!arr[i]) ++ans;
	cout << ans;

	return 0;
}
