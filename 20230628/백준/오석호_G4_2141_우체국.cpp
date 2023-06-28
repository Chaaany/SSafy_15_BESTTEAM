#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 2141 우체국
	// 그리디
	int n, x, a; // x 위치 a 사람
	long long population = 0; // x랑 a가 10억까지 가능하니까
	vector<pair<int, int>> v;
	cin >> n;

	for (int i = 0; i < n; ++i) {
		cin >> x >> a;
		v.push_back(make_pair(x, a));
		population += a;
	}

	// 정렬 후에 인구 절반 이상이 더해지면 거리의 합이 최소가 됨
	sort(v.begin(), v.end());
	long long cnt = 0;
	for (int i = 0; i < v.size(); ++i) {
		cnt += v[i].second;
		// population에 1을 더한 값에 2를 나누는 이유는, 사람 수의 총합이 홀수일 때 중간값에 대한 소수점이 버려지지 않도록 하기 위해서
		// 짝수는 어짜피 나누어 떨어지고 +1 해도 알아서 소수점이 버려지므로 괜찮다
		if (cnt >= (population + 1) / 2) {
			cout << v[i].first;
			return 0;
		}
	}

	return 0;
}
