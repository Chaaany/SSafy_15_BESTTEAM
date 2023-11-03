#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 15723 n단 논법
	// 플로이드와샬
	char c;
	string s;
	int n, m, a, b;
	bool arr[26][26] = { 0 };

	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> c;
		a = c - 'a';
		cin >> s; // is 거르기
		cin >> c;
		b = c - 'a';
		arr[a][b] = true;
	}

	// 플로이드와샬 돌리기
	for (int k = 0; k < 26; ++k) {
		for (int i = 0; i < 26; ++i) {
			for (int j = 0; j < 26; ++j) {
				if (arr[i][k] && arr[k][j]) arr[i][j] = true;
			}
		}
	}

	// 결론추출
	cin >> m;
	for (int i = 0; i < m; ++i) {
		cin >> c;
		a = c - 'a';
		cin >> s;
		cin >> c;
		b = c - 'a';
		
		if (arr[a][b]) cout << "T\n";
		else cout << "F\n";
	}

	return 0;
}
