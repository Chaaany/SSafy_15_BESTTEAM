#include <iostream>
#include <stack>
#include <queue>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 24511 queuestack
	// 큐, 스택
	int n, m, input;
	stack<int> s;
	queue<int> q;
	int arr[100001] = { 0 };

	cin >> n;
	for (int i = 0; i < n; ++i) cin >> arr[i];
	for (int i = 0; i < n; ++i) {
		cin >> input;
		if (!arr[i]) s.push(input);
	}

	while (!s.empty()) {
		q.push(s.top());
		s.pop();
	}

	cin >> m;
	for (int i = 0; i < m; ++i) {
		cin >> input;
		q.push(input);
	}
	for (int i = 0; i < m; ++i) {
		cout << q.front() << " ";
		q.pop();
	}

	return 0;
}
