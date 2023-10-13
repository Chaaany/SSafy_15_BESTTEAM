#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 2312 수 복원하기
	// 수학, 에라토스테네스의 체, 정수론
	int t, n;
	cin >> t;
	while (t--) {
		int arr[100001] = { 0 }; // 해당 수가 몇번 사용됐는지를 저장한 배열
		cin >> n;
		
		int tmp = n; // 수 저장용

		// 무한 소인수분해
		for (int i = 2; i <= tmp; ++i) {
			while (!(tmp % i)) {
				tmp /= i;
				++arr[i];
			}
		}

		// 출력
		for (int i = 2; i <= n; ++i) {
			if (arr[i]) cout << i << " " << arr[i] << '\n';
		}
	}

	return 0;
}
