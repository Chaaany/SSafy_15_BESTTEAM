#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 2036 수열의 점수
	// 그리디
	int n, input;
	vector<int> plus;
	vector<int> minus;
	int zero = 0;
	long long ans = 0;
	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> input;
		if (input > 0) plus.push_back(input);
		else if (input < 0) minus.push_back(input);
		else ++zero;
	}
	
	// 정렬
	sort(plus.begin(), plus.end());
	sort(minus.begin(), minus.end(), greater<int>());

	// 양수는 양수끼리 곱해주기 (1은 다 더해줘야함)
	while (plus.size() > 1) {
		if (plus[plus.size() - 1] == 1 || plus[plus.size() - 2] == 1) break;
		ans += (long long)plus[plus.size() - 1] * (long long)plus[plus.size() - 2];
		plus.pop_back();
		plus.pop_back();
	}
	while (!plus.empty()) {
		ans += plus.back();
		plus.pop_back();
	}

	// 음수는 음수끼리 곱해주기
	while (minus.size() > 1) {
		ans += (long long)minus[minus.size() - 1] * (long long)minus[minus.size() - 2];
		minus.pop_back();
		minus.pop_back();
	}

	// 음수가 남았는데 0이 있다면 처리할 수 있지만 그게 아니면 음수를 ans에 더해준다
	if (!zero && minus.size()) ans += (long long)minus.back();

	cout << ans;

	return 0;
}
