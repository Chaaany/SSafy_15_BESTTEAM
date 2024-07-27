#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

bool isSquare(int n) {
	return !(n & (n - 1));
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 2885 초콜릿 식사
	// 비트마스크
	int k;
	cin >> k;

	// 가장 가까운 2의 배수
	int tmp = 1;
	while (tmp < k) tmp <<= 1;
	cout << tmp << " ";

	// 2진수로 바꿨을 때 앞에서부터 세서 마지막 1까지의 거리
	// 2의 제곱수라면 0
	if (isSquare(k)) cout << 0;
	else {
		string binary = "";
		while (k) {
			binary += to_string(k % 2);
			k >>= 1;
		}

		reverse(binary.begin(), binary.end());

		int ans = 0;
		for (int i = 0; i < binary.size(); ++i) {
			if (binary[i] == '1') ans = i + 1;
		}

		cout << ans;
	}

	return 0;
}
