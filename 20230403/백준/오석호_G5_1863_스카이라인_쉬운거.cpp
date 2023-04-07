#include <iostream>
#include <stack>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1863 스카이라인 쉬운거
	// 스택
	int n, x, y;
	// 건물이 높아질 때만 세면 됨
	int ans = 0;
	// 스택을 쓰는 이유는 높이가 줄어들었을 때 자신보다 높은 건물들을 처리하기 위해서
	stack<int> s;
	// 입력받기
	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> x >> y;
		while (!s.empty() && s.top() >= y) {
			if (s.top() != y) ++ans;
			s.pop();
		}
		s.push(y);
	}
	// 마지막 건물 처리
	y = 0;
	while (!s.empty() && s.top() >= y) {
		if (s.top() != y) ++ans;
		s.pop();
	}
	// 출력
	cout << ans;

	return 0;
}
