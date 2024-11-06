#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 32298 등차수열을 만들어요
	// 애드혹, 수학
	int n, m;
	cin >> n >> m;

	// 최대가 100만을 약간 넘고, 시작값을 2 * m으로 하게 되면
	// 2*m, 3*m ... 형태가 되서 소수가 아닌 양의 정수를 n개만큼 출력할 수 있다.
	// -1이 나오는 케이스는.. 없을 것 같은데..?
	for (int i = 2; i < n + 2; ++i) cout << i * m << " ";

	return 0;
}
