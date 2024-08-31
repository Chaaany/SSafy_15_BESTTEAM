#include <iostream>
#include <string>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 17419 비트가 넘쳐흘러
	// 비트마스킹
	int n;
	string s;
	cin >> n >> s;

	int ans = 0;

	for (int i = 0; i < s.size(); ++i) {
		// ~K + 1은 오른쪽 끝의 연속된 1들이 0으로 바뀌고, 연속이 끝나고 난 뒤의 0이 1이 된다 011 -> 100
		// K가 10110이라고 하면 01001 + 1은 01010이고, (K&((~K)+1)은 00010이 된다.
		// 결국 뒤에서부터 가장 가까운 1부터 0으로 바뀌게 된다.
		if (s[i] == '1') ++ans;
	}

	cout << ans;

	return 0;
}
