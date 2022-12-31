#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1253 좋다
	// 투포인터

	vector<int> v;
	int n, input;
	int ans = 0;
	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> input;
		v.push_back(input);
	}
	sort(v.begin(), v.end());

	// 찾는 과정
	for (int i = 0; i < n; ++i) {
		int s = 0;
		int e = n - 1;
		
		// 많아야 2000번 반복
		// 2000 * 2000 은 1억보다 작으니 가능할듯?
		while (s < e) {
			// 서로 다른 수여야함
			if (i == s) {
				++s;
				continue;
			}
			if (i == e) {
				--e;
				continue;
			}

			if (v[i] == v[s] + v[e]) {
				++ans;
				break;
			}
			else if (v[i] > v[s] + v[e]) ++s;
			else --e;
		}
	}
	cout << ans;

	return 0;
}    
