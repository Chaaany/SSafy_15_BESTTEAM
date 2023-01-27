#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

vector<int> treeVector[50001]; // 연결된 요소를 담은 벡터배열
int depth[50001]; // 해당 요소의 depth
int parent[50001]; // 특정 요소의 부모요소
bool chk[50001]; // 방문여부

int lca(int a, int b) {
    if (depth[a] < depth[b]) swap(a, b); // 항상 a가 b보다 depth가 깊게 설정 (swap함수는 algorithm 라이브러리 내에 존재)
    while (depth[a] != depth[b]) a = parent[a]; // 더 깊은 요소(a)의 depth를 b까지 끌어올림
    while (a != b) { // depth가 같아졌다면 이제 부모요소가 같아질 때까지 부모노드를 계속해서 갱신
        a = parent[a];
        b = parent[b];
    }

    return a;
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    // 11437 LCA
    // 그래프, 트리
    int a, b, n, m;
    queue<int> q;

    cin >> n;
    for (int i = 0; i < n - 1; ++i) {
        cin >> a >> b;
        treeVector[a].push_back(b);
        treeVector[b].push_back(a); // 순서가 정해져서 들어오는게 아님
    }

    // 최상위 요소인 1부터 차례대로 정리
    q.push(1);
    chk[1] = true;
    while (!q.empty()) {
        int tmp = q.front();
        q.pop();
        for (int i = 0; i < treeVector[tmp].size(); ++i) {
            if (!chk[treeVector[tmp][i]]) { // 방문여부 판단
                depth[treeVector[tmp][i]] = depth[tmp] + 1; // 거리체크
                chk[treeVector[tmp][i]] = true; // 방문 체크
                parent[treeVector[tmp][i]] = tmp; // 현재정점의 부모노드는 tmp임
                q.push(treeVector[tmp][i]); // 큐에 다시 넣기
            }
        }
    }

    // 실제 lca 조사하기
    cin >> m;
    for (int i = 0; i < m; ++i) {
        cin >> a >> b;
        cout << lca(a, b) << '\n';
    }
}
