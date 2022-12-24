#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;

long long dp[11][56][56][56];
long long factorial[11];
int n;

long long makeDP(int level, int r, int g, int b) {
	// n보다 큰 레벨을 요구하는 경우 하위 요소를 고려할 필요가 없으므로 바로 1을 return
	// 가장 높은 레벨에서는 1이 되고, 레벨이 낮아질 수록 dp에 의해 경우의 수가 쌓이게 된다
	if (level > n) return 1;

	// 이미 계산된 경우 바로 리턴
	if (dp[level][r][g][b] != 0) return dp[level][r][g][b];

	// 아직 계산되지 않았다면
	long long ans = 0;

	// 한 색깔로 전부 채우는 방법
	// 모든 케이스에서 가능
	// r g b
	if (r - level >= 0) ans += makeDP(level + 1, r - level, g, b);
	if (g - level >= 0) ans += makeDP(level + 1, r, g - level, b);
	if (b - level >= 0) ans += makeDP(level + 1, r, g, b - level);

	// 두 색깔로 전부 채우는 방법 - 순서가 의미가 있으므로 중복순열(level! / (level/2)! / (level/2)!);
	// 레벨이 2로 나눠져야 가능
	// rg rb gb
	if (level % 2 == 0) {
		if (r - level / 2 >= 0 && g - level / 2 >= 0) ans += makeDP(level + 1, r - level / 2, g - level / 2, b) * factorial[level] / (long long)pow(factorial[level / 2], 2);
		if (r - level / 2 >= 0 && b - level / 2 >= 0) ans += makeDP(level + 1, r - level / 2, g, b - level / 2) * factorial[level] / (long long)pow(factorial[level / 2], 2);
		if (b - level / 2 >= 0 && g - level / 2 >= 0) ans += makeDP(level + 1, r, g - level / 2, b - level / 2) * factorial[level] / (long long)pow(factorial[level / 2], 2);
	}

	// 세 색깔로 전부 채우는 방법 - 순서가 의미가 있으므로 중복순열(level! / (level/3)! / (level/3)! / (level/3)!);
	// 레벨이 3으로 나눠져야 가능
	// rgb
	if (level % 3 == 0) {
		if (r - level / 3 >= 0 && g - level / 3 >= 0 && b - level / 3 >= 0) ans += makeDP(level + 1, r - level / 3, g - level / 3, b - level / 3) * factorial[level] / (long long)pow(factorial[level / 3], 3);
	}

	// 결과값 return
	return ans;
}

void makeFactorial(int n) {
	long long ans = 1;
	for (int i = 1; i <= n; ++i) ans *= i;
	factorial[n] = ans;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1234 크리스마스 트리
	// dp
	int r, b, g;
	cin >> n >> r >> g >> b;

	// 팩토리얼 구하기
	for (int i = 1; i <= 10; ++i) makeFactorial(i);

	// 정답 출력하기
	cout << makeDP(1, r, g, b);

	return 0;
}    
