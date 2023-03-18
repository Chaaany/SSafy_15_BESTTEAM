#include <iostream>
#include <string>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1105 팔
	// 그리디
	string a, b;
	cin >> a >> b;
	// 자리수가 다르면 0
	int cnt = 0;
	if (a.size() != b.size()) cout << 0;
	else {
		
		for (int i = 0; i < a.size(); ++i) {
			if (a[i] == b[i] && a[i] == '8') ++cnt;
			else if (a[i] != b[i]) break;
		}
		cout << cnt;
	}
	
	return 0;
}
