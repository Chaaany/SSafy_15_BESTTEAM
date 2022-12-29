#include <stdio.h>
#include <algorithm>

using namespace std;

int n;
int t[1500000], p[1500000], d[1500000];
int ans;

int main(void) {
	// d[i] = i째일까지 얻을 수 있는 최대 수익
	// 점화식....?
	;
	scanf("%d", &n);
	for (int i = 0; i< n; i++) {
		scanf("%d %d", &t[i], &p[i]);
	}

	for (int i = 0; i < n; i++) {
		// i일째에 상담을 하지 않는 경우
		// -> 바로 다음날로 넘어감
		d[i+1] = max(d[i], d[i+1]);

		// i일째에 상담을 하는 경우
		d[i+t[i]] = max(d[i+t[i]], d[i]+p[i]);
	}

	printf("%d\n", d[n]);
}
