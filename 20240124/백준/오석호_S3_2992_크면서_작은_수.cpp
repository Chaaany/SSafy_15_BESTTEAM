#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 2992 크면서 작은 수
	// 브루트포스
	string s;
	cin >> s;

	// 다음 순열이 있는지 확인하고 있으면 출력 없으면 0
	if (next_permutation(s.begin(), s.end())) cout << s;
	else cout << "0";

	return 0;
}
