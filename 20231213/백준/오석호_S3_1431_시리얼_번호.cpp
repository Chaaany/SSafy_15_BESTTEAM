#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

bool cmp(string a, string b) {
	// 길이 비교
	if (a.size() != b.size()) return a.size() < b.size();
	// 자리수 합 비교
	int aSum = 0;
	int bSum = 0;
	for (char c : a) if (c >= 48 && c <= 57) aSum += c;
	for (char c : b) if (c >= 48 && c <= 57) bSum += c;
	if (aSum != bSum) return aSum < bSum;
	// 사전순 비교
	return a < b;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1431 시리얼 번호
	// 정렬
	int n;
	string s;
	vector<string> v;
	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> s;
		v.push_back(s);
	}
	sort(v.begin(), v.end(), cmp);
	for (int i = 0; i < n; ++i) cout << v[i] << '\n';

	return 0;
}
