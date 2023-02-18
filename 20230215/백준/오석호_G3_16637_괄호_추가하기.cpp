#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

// 전역에 값 선언
int n;
string s;
// int형의 최솟값인 2^31 - 1 을 넣어둠
int ans = -2147483647;

int calc(int idx) {
	// 아스키코드를 이용해서 숫자형태로 변경
	int num1 = s[idx] - '0';
	int num2 = s[idx + 2] - '0';
	if (s[idx + 1] == '+') return num1 + num2;
	else if (s[idx + 1] == '-') return num1 - num2;
	else if (s[idx + 1] == '*') return num1 * num2;
}

void dfs(int idx, int sum) {
	// idx가 n 넘어가면 ans값 갱신
	if (idx > n) {
		ans = max(ans, sum);
		return;
	}
	// 이외의 경우에는 dfs 돌리기
	else if (s[idx - 1] == '+') {
		// 괄호 안씌우는 경우
		dfs(idx + 2, sum + (s[idx] - '0'));
		// 괄호 씌우는 경우
		if (idx + 2 < n) dfs(idx + 4, sum + calc(idx));
	}
	else if (s[idx - 1] == '-') {
		// 괄호 안씌우는 경우
		dfs(idx + 2, sum - (s[idx] - '0'));
		// 괄호 씌우는 경우
		if (idx + 2 < n) dfs(idx + 4, sum - calc(idx));
	}
	else if (s[idx - 1] == '*') {
		// 괄호 안씌우는 경우
		dfs(idx + 2, sum * (s[idx] - '0'));
		// 괄호 씌우는 경우
		if (idx + 2 < n) dfs(idx + 4, sum * calc(idx));
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 16637 괄호 추가하기
	// 브루트포스

	// 입력값 받기
	cin >> n >> s;
	
	// 연산하기
	if (n != 1) dfs(2, s[0] - '0');
	else ans = s[0] - '0';

	// 출력
	cout << ans;
	
	return 0;
}
