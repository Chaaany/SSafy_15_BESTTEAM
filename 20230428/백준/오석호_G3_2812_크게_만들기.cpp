#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);	
	cout.tie(NULL);

	// 2812 크게 만들기
	// 그리디
	int n, k;
	string s;
	vector<char> v;
	cin >> n >> k >> s;
	for (int i = 0; i < n; ++i) {
		// 타겟보다 작은 수가 벡터의 맨 뒤에 존재하면 제거
		while (k && v.size() && v[v.size() - 1] < s[i]) {
			v.pop_back();
			--k;
		}
		// 타겟을 벡터에 넣음
		v.push_back(s[i]);
	}
	// v.size()-k개만 출력
	for (int i = 0; i < v.size() - k; ++i) cout << v[i];

	return 0;
}
