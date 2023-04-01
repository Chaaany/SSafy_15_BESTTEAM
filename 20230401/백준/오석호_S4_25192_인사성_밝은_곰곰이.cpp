#include <iostream>
#include <string>
#include <map>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 25192 인사성 밝은 곰곰이
	// 맵
	map<string, bool> chk;
	int ans = 0;
	int n;
	string input;
	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> input;
		if (input == "ENTER") chk.clear();
		else {
			if (!chk[input]) {
				chk[input] = true;
				++ans;
			}
		}
	}
	cout << ans;

	return 0;
}
