#include <iostream>
#include <deque>
#include <cmath>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(NULL);

	// 2346 풍선 터뜨리기
	// 자료구조, 덱
	int n, input;
	deque<pair<int, int>> dq;
	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> input;
		dq.push_back(make_pair(input, i + 1));
	}

	while (!dq.empty()) {
		// 풍선 터뜨림
		int tmp = dq.front().first;
		cout << dq.front().second << " ";
		dq.pop_front();

		// 종료조건
		if (dq.empty()) break;

		// 양수일 때는 오른쪽으로 이동
		if (tmp > 0) {
			for (int i = 0; i < tmp - 1; ++i) {
				dq.push_back(dq.front());
				dq.pop_front();
			}
		}
		// 음수일 때는 왼쪽으로 이동
		else {
			for (int i = 0; i < abs(tmp); ++i) {
				dq.push_front(dq.back());
				dq.pop_back();
			}
		}
	}

	return 0;
}
