#include <iostream>
#include <set>
#include <string>
using namespace std;

// 비트 형태의 불 (0~9)
string numBit[10] = { "1110111", "0010010", "1011101", "1011011", "0111010", "1101011", "1101111", "1010010", "1111111", "1111011" };
set<string> s;

void dfs(int idx, string result, string n, int k, int p, string x) {
	// 자리수 꽉채웠으면 끝내기
	if (idx == k) {
		// 최대 층수보다 낮아야함
		if (result <= n) s.insert(result);
		return;
	}

	// 0부터 9까지 변환
	for (int i = 0; i < 10; ++i) {
		int cnt = 0;
		// 모든 케이스 브루트포스
		for (int j = 0; j < 7; ++j) {
			if (numBit[x[idx] - '0'][j] != numBit[i][j]) ++cnt;
		}

		// 가능한 모든 케이스에 대해서 dfs 돌리기
		if (cnt <= p) dfs(idx + 1, result + to_string(i), n, k, p - cnt, x);
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 22251 빌런 호석
	// DFS
	string n, x; // n은 엘리베이터의 최대 층수, x는 엘리베이터가 실제 멈춰있는 층
	int k, p; // k는 디스플레이에 보이는 자리수, p는 LED에서 반전 가능한 자리수
	cin >> n >> k >> p >> x;

	// 현재층
	string now = "";
	for (int i = n.size(); i < k; ++i) {
		n = '0' + n;
		now += '0';
	}
	for (int i = x.size(); i < k; ++i) x = '0' + x;

	// 0층
	string zero = "";
	for (int i = 0; i < k; i++) zero += '0';

	// dfs 돌리기 (set 채우기)
	dfs(now.size(), now, n, k, p, x);

	// 정답은 set 개수에서 시작층과 0층 제거한 값
	int ans = s.size();

	if (s.find(zero) != s.end()) --ans;
	if (s.find(x) != s.end()) --ans;
	
	cout << ans;

	return 0;
}
