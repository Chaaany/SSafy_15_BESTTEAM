#include <iostream>
#include <algorithm>
#include <set>
#include <string>
using namespace std;

int cases[8][3] = { {0, 1, 2},{3, 4, 5},{6, 7, 8},{0, 3, 6},{1, 4, 7},{2, 5, 8},{0, 4, 8},{2, 4, 6} }; // 이어졌을 때 끝나는 케이스
set<string> ansCases;
int tmp[3][3] = { 0 };

// 승리 여부를 판단하는 chk 함수
bool chk(string s, int i) {
	if (s[cases[i][0]] == '.' || s[cases[i][0]] != s[cases[i][1]] || s[cases[i][0]] != s[cases[i][2]]) return false;
	else return true;
}

// 모든 가능한 케이스를 전수조사하는 bf 함수
void bf(int n) {
	string s;
	for (int i = 0; i < 3; ++i) {
		for (int j = 0; j < 3; ++j) {
			if (tmp[i][j] == 1) s += 'X';
			else if (tmp[i][j] == 2) s += 'O';
			else s += '.';
		}
	}
	// 8개의 정답 케이스 중 하나라도 걸리면 끝
	for (int i = 0; i < 8; ++i) {
		if (chk(s, i)) {
			ansCases.insert(s);
			return;
		}
	}
	// 보드에 값이 전부 채워졌을 때 안끝나는 케이스들도 정답에 넣기
	if (n == 9) {
		ansCases.insert(s);
		return;
	}
	// 브루트포스
	for (int i = 0; i < 3; ++i) {
		for (int j = 0; j < 3; ++j) {
			// 이미 누가 놓은 위치면 continue
			if (tmp[i][j] != 0) continue;
			// 먼저 놓는 사람이 X이므로, 1일 때 X 2일 때 O로 생각
			tmp[i][j] = n % 2 + 1;
			// 다음 턴
			bf(n + 1);
			// 그 위치에 안놓는 케이스도 생각
			tmp[i][j] = 0;
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 7682 틱택토
	// 브루트포스
	string s;
	bf(0);
	while (1) {
		cin >> s;
		if (s == "end") break;
		if (ansCases.find(s) != ansCases.end()) cout << "valid" << '\n';
		else cout << "invalid" << '\n';
	}

	return 0;
}
