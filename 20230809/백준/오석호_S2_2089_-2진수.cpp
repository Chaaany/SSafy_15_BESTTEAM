#include <iostream>
#include <string>
#include <algorithm>
using namespace std;


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 2089 -2진수
	// 수학
	int n;
	cin >> n;
	if (!n) cout << "0";
	else {
		string ans;
		while (n) {
			if (n % 2) {
				ans += "1";
				n = (n - 1) / -2; // 내림을 위해서 -1을 해준다
			}
			else {
				ans += "0";
				n /= -2; // 어짜피 자동으로 버림(내림)이 되니까 그대로 나눠줘도 된다
			}
		}
		reverse(ans.begin(), ans.end());
		cout << ans;
	}

	return 0;
}
