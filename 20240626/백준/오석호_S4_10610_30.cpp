#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 10610 30
	// 그리디
	string s;
	cin >> s;

	int sum = 0;
	bool chk = false;
	for (int i = 0; i < s.size(); ++i) {
		sum += s[i];
		if (s[i] == '0') chk = true;
	}

	// 3의 배수이면서 10의 배수이면 됨 -> 3의 배수 확인하고 0이 있다면 내림차순 정렬한 수를 보여주면 됨
	if (sum % 3 == 0 && chk) {
		sort(s.begin(), s.end(), greater<>());
		cout << s;
	}
	else cout << -1;

	return 0;
}
