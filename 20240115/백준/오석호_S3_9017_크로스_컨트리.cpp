#include <iostream>
#include <vector>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 9017 크로스 컨트리
	// 구현
	int t, n;
	int arr[1001] = { 0 }; // 순위
	int p[201] = { 0 }; // 팀별 인원수
	int s[201] = { 0 }; // 팀별 점수
	int pp[201] = { 0 }; // 현재까지 들어온 인원수
	int f[201] = { 0 }; // 다섯번째 주자의 점수
	int ans = 0; // 우승팀
	cin >> t;

	while (t--) {
		cin >> n;
		// 인원수 및 다섯번째 주자의 점수 초기화 (순위는 안해도 됨)
		for (int i = 1; i <= n; ++i) {
			p[i] = 0;
			s[i] = 0;
			pp[i] = 0;
			f[i] = 0;
		}

		// 입력
		int maxTeamNum = 0;
		for (int i = 1; i <= n; ++i) {
			cin >> arr[i];
			++p[arr[i]];
			if (maxTeamNum < arr[i]) maxTeamNum = arr[i];
		}
		
		// 점수계산
		int score = 1;
		for (int i = 1; i <= n; ++i) {
			if (p[arr[i]] == 6) {
				++pp[arr[i]];
				if (pp[arr[i]] <= 4) s[arr[i]] += score;
				if (pp[arr[i]] == 5) f[arr[i]] = score;
				++score;
			}
		}

		// 순위경쟁
		vector<int> v; // 1등만 들어있는 벡터
		int minScore = 6001; // 최대 1000명에 6명이 들어와야 하니 대충 6001 넣음
		for (int i = 1; i <= maxTeamNum; ++i) {
			if (s[i] != 0 && s[i] < minScore) {
				v.clear();
				v.push_back(i);
				minScore = s[i];
			}
			else if (s[i] != 0 && s[i] == minScore) v.push_back(i);
		}

		// 출력
		if (v.size() == 1) cout << v[0] << '\n';
		else {
			int minFive = 1001;
			int winner = 0;
			for (int i = 0; i < v.size(); ++i) {
				if (f[v[i]] < minFive) {
					winner = v[i];
					minFive = f[v[i]];
				}
			}
			cout << winner << '\n';
		}
	}

	return 0;
}
