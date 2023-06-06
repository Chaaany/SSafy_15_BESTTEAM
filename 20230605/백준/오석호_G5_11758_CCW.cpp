#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 11758 CCW
  // 기하학
  int x1, y1, x2, y2, x3, y3;
  cin >> x1 >> y1 >> x2 >> y2 >> x3 >> y3;
  if (((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1)) / 2 > 0) cout << '1' << '\n';
  else if (((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1)) / 2 < 0) cout << "-1" << '\n';
  else cout << '0' << '\n';

	return 0;
}
