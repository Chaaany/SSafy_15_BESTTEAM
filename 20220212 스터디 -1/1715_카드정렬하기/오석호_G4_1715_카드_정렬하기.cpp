#include <iostream>
#include <queue>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	// 1715 카드 정렬하기
	// 가장 작은 수 두개를 합치면 된다
	// 우선순위큐?
	priority_queue<int, vector<int>, greater<int>> pq;
	int n, tmp;
	int answer = 0;

	cin >> n;

	for (int i = 0; i < n; ++i) {
		cin >> tmp;
		pq.push(tmp);
	}
  
	while (pq.size() != 1) {
		int sum = 0;
		for (int i = 0; i < 2; ++i) {
			sum += pq.top();
			pq.pop();
		}
		answer += sum;
		
		pq.push(sum);
	}

	cout << answer;
	
	return 0;
}
