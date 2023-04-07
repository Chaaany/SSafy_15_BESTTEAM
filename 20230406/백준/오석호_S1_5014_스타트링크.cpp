#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 5014 스타트링크
    // 브루트포스
    int f, s, g, u, d; // 순서대로 빌딩 높이, 현재 위치, 목표 위치, up_step, down_step
    cin >> f >> s >> g >> u >> d;
    // 100만번인 이유는 같은데 또가봤자 의미없으니까 100만번 안에는 결판이 난다
    for (int i = 0; i < 1000000; ++i) {
        if (s == g) {
            cout << i;
            return 0;
        }
        // 범위 체크
        if (s + u > f && s - d < 1) break;
        // 올라갈 수 있으면 올라감
        if (s < g && s + u <= f) s += u;
        // (현재 위치가 목표 위치보다 높은데다 내려갈 수 없는 상황)이 아니라면 내려감
        else if (!(s > g && s - d < 1)) s -= d;
        // 그것도 안되면 걍 일단 올라가고 보자
        else if (s + u <= f) s += u;
        // 근데 올라갈데가 없다? 걍 면접 보지 마라
        else break;
    }
    cout << "use the stairs";

	return 0;
}
