#include <iostream>
#include <queue>
using namespace std;

int n;
int ans = 0;
char c;
int parent[51];
priority_queue<pair<int, pair<int, int>>> pq;

int getParent(int x) {
	if (x == parent[x]) return x;
	return parent[x] = getParent(parent[x]);
}

bool isSameParent(int a, int b) {
	a = getParent(a);
	b = getParent(b);

	if (a == b) return true;
	else return false;
}

void makeUnion(int a, int b) {
	a = getParent(a);
	b = getParent(b);

	if (a < b) parent[b] = a;
	else parent[a] = b;
}


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1414 불우이웃돕기
	// Union-find
	cin >> n;
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			cin >> c;
			int cost = 0;
			if ('a' <= c && c <= 'z') cost = c - 'a' + 1;
			else if ('A' <= c && c <= 'Z') cost = c - 'A' + 27;

			if (c != '0') {
				ans += cost; // 일단 모든 랜선 길이를 ans에 넣어두고 나중에 쓸 때 빼기
				pq.push(make_pair(-cost, make_pair(i, j)));
			}
		}
	}

	// parent 자기 자신으로 초기화
	for (int i = 0; i < n; ++i) parent[i] = i;

	// 유파 돌리면서 하나씩 줄여나가기 (pq라서 cost가 적은 것들을 먼저 사용하게됨)
	int cnt = 0;
	while (!pq.empty()) {
		pair<int, pair<int, int>> tmp = pq.top();
		pq.pop();
		// 연결되어있지 않으면 연결하기
		if (!isSameParent(tmp.second.first, tmp.second.second)) {
			makeUnion(tmp.second.first, tmp.second.second);
			// 연결에 필요한 랜선길이 빼주기
			ans += tmp.first;
			++cnt;
		}
	}
	
	// 다 연결됐으면 출력 (만약 cnt가 n-1이 아니면 -1)
	if (cnt != n - 1) cout << -1;
	else cout << ans;

	return 0;
}
