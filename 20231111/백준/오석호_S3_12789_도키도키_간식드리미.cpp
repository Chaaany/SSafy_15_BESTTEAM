#include <iostream>
#include <stack>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 12789 도키도키 간식드리미
	// 스택
	int n;
	int arr[1001] = { 0 };
	stack<int> s;
	cin >> n;
	for (int i = 0; i < n; ++i) cin >> arr[i];

	int now = 1; // 들어가야 하는 사람
	int cnt = 0; // 줄선 순서 인덱스
	for (int i = 0; i < n; ++i) {
		// 스택이 비어있으면 우선 채우기
		if (s.empty() && cnt < n) s.push(arr[cnt++]);

		// 스택 맨 위가 들어가야 하는 사람이 아니라면, 현재 들어가야 하는 사람이 나올 때까지 스택에 넣기
		while (s.top() != now && cnt < n) s.push(arr[cnt++]);

		// 들어가야 하는 사람이 스택 맨 위면 넣기
		if (!s.empty() && s.top() == now) {
			s.pop();
			++now;
		}
		else {
			cout << "Sad";
			return 0;
		}
	}
	cout << "Nice";

	return 0;
}
