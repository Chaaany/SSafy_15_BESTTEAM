#include <iostream>
#include <vector>
using namespace std;

int parent[201];

int getParent(int x) {
	if (parent[x] == x) return x;
	return parent[x] = getParent(parent[x]);
}

void unionParent(int a, int b) {
	a = getParent(a);
	b = getParent(b);
	parent[a] = b;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	// 1976 여행 가자
	// Union-Find
	int n, m, input;
	vector<int> v;
	cin >> n >> m;
	
	// 초기화
	for (int i = 1; i <= n; ++i) {
		parent[i] = i;
	}

	// 유니온처리
	for (int i = 1; i <= n; ++i) {
		for (int j = 1; j <= n; ++j) {
			cin >> input;
			if (input == 1) unionParent(i, j);
		}
	}

	// vector에 여행 계획 저장해두기
	for (int i = 0; i < m; ++i) {
		cin >> input;
		v.push_back(input);
	}

	// 전부 같은 부모를 가지는지 확인
	bool chk = true;
	int targetParent = getParent(v[0]);

	for (int i = 1; i < m; ++i) {
		if (getParent(v[i]) != targetParent) {
			chk = false;
			break;
		}
	}

	if (chk) cout << "YES";
	else cout << "NO";

	return 0;
}
