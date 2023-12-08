#include <iostream>
using namespace std;

int n, m;
int cowWeight[9]; // 소 무게
bool chk[9]; // 해당 소를 연산에 사용했는지 여부
bool sumWeight[9001]; // 무게의 합으로 만들 수 있는 케이스인지 여부 (소수만 true가 될 수 있음)

bool isPrime(int x) {
	bool prime = true;
	for (int i = 2; i * i <= x; ++i) {
		if (!(x % i)) {
			prime = false;
			break;
		}
	}
	return prime;
}

void dfs(int s, int cnt) {
	if (cnt == m) {
		int sum = 0;
		for (int i = 0; i < n; ++i) {
			if (chk[i]) sum += cowWeight[i];
		}
		if (isPrime(sum)) sumWeight[sum] = true;
	}
	else {
		for (int i = s; i < n; ++i) {
			chk[i] = true;
			dfs(i + 1, cnt + 1); // 모든 케이스 브루트포스
			chk[i] = false;
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 19699 소-난다!
	// DFS
	cin >> n >> m;
	for (int i = 0; i < n; ++i) cin >> cowWeight[i];
	
	dfs(0, 0); // dfs

	bool isExistPrime = false;
	for (int i = 1; i <= 9000; ++i) {
		if (sumWeight[i]) {
			cout << i << " ";
			isExistPrime = true;
		}
	}
	if (!isExistPrime) cout << -1;

	return 0;
}
