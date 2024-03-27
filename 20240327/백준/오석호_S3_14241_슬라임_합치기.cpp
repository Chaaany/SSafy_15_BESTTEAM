#include <iostream>
#include <queue>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(NULL);

	// 14241 슬라임 합치기
	// 우선순위큐
	int n, input;
	int ans = 0;
	priority_queue<int> pq;

	cin >> n;

	for (int i = 0; i < n; ++i) {
		cin >> input;
		pq.push(input);	// 입력받은 크기를 pq에 저장
	}

	// pq에 값이 하나 남을 때까지 돌리기
	while (pq.size() > 1) {
		int a = pq.top();
		pq.pop();
		int b = pq.top();
		pq.pop();

		int size = a + b;
		int score = a * b;

		pq.push(size); // 합쳐진 슬라임 pq에 넣기
		ans += score; // 점수 추가
	}

	cout << ans << "\n";

	return 0;
}
