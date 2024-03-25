#include <iostream>
#include <stack>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(NULL);

	// 6198 옥상 정원 꾸미기
	// 스택
	int n, input;
	stack<int> s;
	long long ans = 0;
	cin >> n;

	for (int i = 0; i < n; ++i) {
		cin >> input;

		// 만약 이전 빌딩의 높이가 input보다 크면 스택에 들어가있는 빌딩들은 모두 input 빌딩을 볼 수 있다
		// 그게 아니라면 해당 빌딩꼭대기는 뒷 건물들은 확인할 수 없으므로 스택에서 제거한다
		while (!s.empty()) {
			if (s.top() > input) break;
			s.pop();
		}

		ans += (long long)s.size();
		s.push(input);
	}
	cout << ans;

	return 0;
}
