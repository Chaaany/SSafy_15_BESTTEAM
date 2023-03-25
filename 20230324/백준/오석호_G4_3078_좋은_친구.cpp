#include <iostream>
#include <string>
#include <queue>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 3078 좋은 친구
	// 큐
	int n, k;
	string s;
	queue<int> q[21]; // 친구를 담은 큐
	long long ans = 0; // 좋은 친구의 수

	cin >> n >> k;
	for (int i = 0; i < n; ++i) {
		cin >> s;
		// 받은 이름의 사이즈와 같은 친구들이 있는 큐가 비어있지 않고, 등수가 k보다 많이 차이가 나면 이름 길이 사이즈에 맞는 큐를 하나씩 비워나감
		while (q[s.size()].size() != 0 && i - q[s.size()].front() > k) q[s.size()].pop();
		// 친한애 수 더하기
		ans += q[s.size()].size();
		// 처리가 끝난 친구 큐에 넣기 (인덱스)
		q[s.size()].push(i);
	}

	cout << ans;
	
	return 0;
}
