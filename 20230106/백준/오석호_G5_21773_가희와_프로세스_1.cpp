#include <iostream>
#include <queue>
#include <tuple>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 21773 가희와 프로세스 1
	// 우선순위큐
	priority_queue<tuple<int, int, int>> pq;
	int n, t, input1, input2, input3;
	cin >> n >> t;
	for (int i = 0; i < t; ++i) {
		cin >> input1 >> input2 >> input3;
		pq.push(make_tuple(input3, -input1, input2)); // 우선순위, id, 남은시간 (id값 작은걸 우선순위로 두기 위해 음수처리하는 트릭을 씀)
	}
	for (int i = 0; i < n; ++i) {
		tuple<int, int, int> tmp = pq.top();
		pq.pop();
		if (get<2>(tmp) > 1) pq.push(make_tuple(get<0>(tmp) - 1, get<1>(tmp), get<2>(tmp) - 1));
		cout << -get<1>(tmp) << '\n';
	}

	return 0;
}    
