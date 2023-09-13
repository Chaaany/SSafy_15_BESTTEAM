#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1244 스위치 켜고 끄기
	// 구현
	int n, sn, a, b;
	bool arr[101] = { 0 };
	cin >> n;
	for (int i = 1; i <= n; ++i) cin >> arr[i];
	cin >> sn;
	for (int i = 0; i < sn; ++i) {
		cin >> a >> b;
		if (a == 1) {
			for (int j = 1; j <= n; ++j) {
				if (j % b == 0) arr[j] = !arr[j];
			}
		}
		else if (a == 2) {
			arr[b] = !arr[b];
			for (int j = 1; arr[b + j] == arr[b - j]; ++j) {
				if (b + j > n || b - j < 1) break; // 인덱스 벗어나면 break
				arr[b + j] = !arr[b + j];
				arr[b - j] = !arr[b - j];
			}
		}
	}

	// 출력
	for (int i = 1; i <= n; ++i) {
		cout << arr[i] << " ";
		if (!(i % 20)) cout << '\n';
	}

	return 0;
}
