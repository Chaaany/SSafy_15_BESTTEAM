#include <iostream>
using namespace std;

int gcd(int a, int b) { 
	while (b) { 
		int tmp = b; 
		b = a % b; 
		a = tmp;
	} 
	return a; 
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 2168 타일 위의 대각선
	// 정수론
	int x, y;
	cin >> x >> y;
	cout << x + y - gcd(x, y);

	return 0;
}
