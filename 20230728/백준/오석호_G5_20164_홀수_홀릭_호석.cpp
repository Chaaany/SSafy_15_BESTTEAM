#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int minValue = 1000000000;
int maxValue = -1;

int oddCount(int n) {
	int cnt = 0;
	while (n) {
		if (n % 2) ++cnt;
		n /= 10;
	}
	return cnt;
}

void ret(int target, int cnt) {
	// 한자리 - 종료
	if (target < 10) {
		maxValue = max(cnt, maxValue);
		minValue = min(cnt, minValue);
	}
	// 두자리 - 두개로 나눈 합으로 생각
	else if (target < 100) {
		int sum = target / 10 + target % 10;
		ret(sum, cnt + oddCount(sum));
	}
	// 세자리 이상 - 임의의 위치에서 3개로 분할 후 더해서 생각
	else {
		string s = to_string(target);
		// 브루트포스
		for (int i = 1; i < s.size() - 1; ++i) {
			for (int j = i + 1; j < s.size(); ++j) {
				string s1 = s.substr(0, i);
				string s2 = s.substr(i, j - i);
				string s3 = s.substr(j, s.size() - j);
				int sum = stoi(s1) + stoi(s2) + stoi(s3);
				ret(sum, cnt + oddCount(sum));
			}
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 20164 홀수 홀릭 호석
	// 재귀
	int n;
	cin >> n;
	ret(n, oddCount(n));
	cout << minValue << " " << maxValue;

	return 0;
}
