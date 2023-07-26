#include <iostream>
#include <queue>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 15903 카드 합체 놀이
	// 그리디
	int n, m, a, x, y;
	priority_queue<int, vector<int>, greater<int>> pq;
	cin >> n >> m;
	for (int i = 0; i < n; ++i) {
		cin >> a;
		pq.push(a);
	}

	// 제일 작은거 2개를 pq에서 빼서 더한걸 pq에 2번 넣는다
	for (int i = 0; i < m; ++i) {
		x = pq.top();
		pq.pop();
		y = pq.top();
		pq.pop();
		pq.push(x + y);
		pq.push(x + y);
	}
	
	// 최대로 나올 수 있는 합은 1,000,000 * 15,000 = 150억 -> long long이어야함
	long long sum = 0;
	while (!pq.empty()) {
		sum += (long long)pq.top();
		pq.pop();
	}
	cout << sum;

	return 0;
}
