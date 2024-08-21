#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 5635 생일
	// 구현
	int n;
	cin >> n;

	// <<연도, 월>,<일, 이름>> 형태로 데이터를 저장
	vector<pair<pair<int, int>, pair<int, string>>>name(n);

	for (int i = 0; i < n; ++i) {
		cin >> name[i].second.second >> name[i].second.first >> name[i].first.second >> name[i].first.first;
	}

	// 오름차순 정렬 (앞일수록 나이가 많은 사람)
	sort(name.begin(), name.end());

	// 제일 나이가 적은 사람과 제일 나이가 많은 사람을 출력
	cout << name[n - 1].second.second << '\n' << name[0].second.second << '\n';

	return 0;
}
