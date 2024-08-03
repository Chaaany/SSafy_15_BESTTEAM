#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 11561 징검다리
	// 이분탐색
	int t;
	long long n;
	cin >> t;

	// 1부터 n까지 점프하면 n(n+1)/2칸 이동
	while (t--) {
		cin >> n;
		long long s = 1;
		long long e = 10000000001;

		while (s <= e) {
			long long m = (s + e) / 2;
			long long tmp = m * (m + 1) / 2;

			if (tmp == n) {
				// 정답
				e = m;
				break;
			}
			else if (tmp < n) {
				// 중앙값보다 큼
				s = m + 1;
			}
			else {
				// 중앙값보다 작음
				e = m - 1;
			}
		}

		cout << e << '\n';
	}

	return 0;
}
