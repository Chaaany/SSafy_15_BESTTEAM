#include <iostream>
#include <string>
#include <map>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(NULL);

	// 1969 DNA
	// 브루트포스
	int n, m;
	cin >> n >> m;

	string s[1000];
	string ans = ""; // 각 인덱스에서 가장 공통점이 많은 글자가 ans의 각 인덱스에 들어가게 됨
	int hd = 0;
	for (int i = 0; i < n; ++i) cin >> s[i];

	for (int i = 0; i < m; ++i) {
		map<char, int> mm;
		for (int j = 0; j < n; ++j) ++mm[s[j][i]]; // 특정 위치의 알파벳이 몇번 나오는지 세기

		char c;
		int maxValue = 0;
		// mm을 순회하면서 최댓값과 그 알파벳을 구한다 (map은 디폴트가 키정렬이라 알아서 알파벳 순서가 맞춰짐)
		for (auto a : mm) {
			if (maxValue < a.second) {
				maxValue = a.second;
				c = a.first;
			}
		}
		ans += c; // ans에 빈출글자 등록
		hd += n - maxValue; // 해밍웨이 거리 구하기
	}

	cout << ans << '\n' << hd;

	return 0;
}
