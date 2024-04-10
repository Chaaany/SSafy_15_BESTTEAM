#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(NULL);

	// 5545 최고의 피자
	// 그리디
	int n, a, b, c, d; // 토핑 수, 도우 가격, 토핑 가격, 도우 열량, 토핑 열량
	vector<int> v; // 토핑 열량을 담은 벡터
	cin >> n >> a >> b >> c;
	for (int i = 0; i < n; ++i) {
		cin >> d;
		v.push_back(d);
	}

	sort(v.begin(), v.end(), greater<>());

	// 현재 피자 열량 / 피자 가격 < 토핑 열량 / 토핑 가격 이면 그 토핑을 올려야 함
	for (int i = 0; i < n; ++i) {
		if (c / a < v[i] / b) {
			c += v[i];
			a += b;
		}
		else break;
	}

	cout << c / a;

	return 0;
}
