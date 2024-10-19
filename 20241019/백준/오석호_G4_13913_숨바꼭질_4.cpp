#include <iostream>
#include <queue>
using namespace std;

int n, k;
int dist[100001]; // 거리가 얼마나 되는지
int path[100001]; // 어디에서 왔는지

void getPath(int p) {
	if (p != n) getPath(path[p]);
	cout << p << ' ';
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 13913 숨바꼭질 4
	// bfs
	cin >> n >> k;

	// 0도 위치에 포함될 수 있으니 초기화
	for (int i = 0; i < 100001; ++i) path[i] = -1;

	// 수빈이 위치 넣기
	queue<int> q;
	q.push(n);

	dist[n] = 1;
	path[n] = n;

	// 최단거리 찾기 전에는 무한으로 돌리기
	while (!(q.empty() || dist[k])) {
		int tmp = q.front(); // 위치 추출
		q.pop();

		// 3가지 케이스 돌리기
		int a = tmp * 2;
		int b = tmp + 1;
		int c = tmp - 1;

		if (a >= 0 && a <= 100000 && !dist[a]) {
			dist[a] = dist[tmp] + 1;
			path[a] = tmp;
			q.push(a);
		}

		if (b >= 0 && b <= 100000 && !dist[b]) {
			dist[b] = dist[tmp] + 1;
			path[b] = tmp;
			q.push(b);
		}

		if (c >= 0 && c <= 100000 && !dist[c]) {
			dist[c] = dist[tmp] + 1;
			path[c] = tmp;
			q.push(c);
		}
	}

	cout << dist[k] - 1 << '\n';
	getPath(k);

	return 0;
}
