#include <iostream>
using namespace std;

double x[10001];
double y[10001];

long double ccw(int i, int j) {
	return (x[0] * y[i] + x[i] * y[j] + x[j] * y[0] - (x[i] * y[0] + x[j] * y[i] + x[0] * y[j])) / 2;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 2166 다각형의 면적
	// 기하학
	int n;
	double ans = 0;
	
	cin >> n;
	for (int i = 0; i < n; ++i) cin >> x[i] >> y[i];
	for (int i = 1; i < n - 1; ++i) ans += ccw(i, i + 1);

	cout << fixed;
	cout.precision(1);
	cout << abs(ans) << endl;

	return 0;
}
