#include <iostream>
#include <vector>
using namespace std;

bool chk[200001];
bool chk2[200001];
vector<int> v[200001];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 17241 Pineapple Advertising
	// 그래프
	int n, m, q, a, b, nn;
	cin >> n >> m >> q;
	for (int i = 0; i < m; ++i) {
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}
	for (int i = 0; i < q; ++i) {
		cin >> nn;
		if (chk2[nn]) {
			cout << 0 << '\n';
			continue;
		}
		else chk2[nn] = 1;
		int changed = 0;
		if (!chk[nn]) {
			chk[nn] = 1;
			++changed;
		}
		for (int k = 0; k < v[nn].size(); ++k) {
			if (!chk[v[nn][k]]) {
				++changed;
				chk[v[nn][k]] = 1;
			}
		}
		cout << changed << '\n';
	}

	return 0;
}
