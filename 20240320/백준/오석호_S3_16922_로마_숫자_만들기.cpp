#include <iostream>
#include <set>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(NULL);

	// 16922 로마 숫자 만들기
	// 브루트포스
	set<int> s;
	int n;
	cin >> n;

	// I, V, X, L로 만들 수 있는 모든 케이스를 만들어서 set에 넣기
	for (int i = 0; i <= n; ++i) {
		for (int v = 0; v <= n - i; ++v) {
			for (int x = 0; x <= n - i - v; ++x) {
				int l = n - i - v - x;
				int sum = i + v * 5 + x * 10 + l * 50;
				s.insert(sum);
			}
		}
	}

	// 중복이 제거된 값들의 개수를 출력
	cout << s.size();

	return 0;
}
