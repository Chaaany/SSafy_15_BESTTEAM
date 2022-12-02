#include <iostream>
#include <string>
#include <queue>
using namespace std;

char arr[50][50];
int chk[50][50];
int dr[4] = { 1, 0, -1, 0 };
int dc[4] = { 0, 1, 0 ,-1 };

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(NULL);

    // 2589 보물섬
    // BFS
    int n, m;
    string tmp;
    cin >> n >> m;
    for (int i = 0; i < n; ++i) {
        cin >> tmp;
        for (int j = 0; j < m; ++j) {
            arr[i][j] = tmp[j];
        }
    }

    queue<pair<int, int>> q;
    int max = -1;

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            for (int k = 0; k < n; ++k) {
                for (int l = 0; l < m; ++l) {
                    chk[k][l] = -1;
                }
            }
            if (arr[i][j] == 'L') {
                q.push(make_pair(i, j));
                chk[i][j] = 0;
                while (!q.empty()) {
                    int r = q.front().first;
                    int c = q.front().second;
                    q.pop();
                    for (int k = 0; k < 4; ++k) {
                        int rr = r + dr[k];
                        int cc = c + dc[k];
                        if (rr < 0 || rr >= n || cc < 0 || cc >= m) continue;
                        if (arr[rr][cc] == 'L' && chk[rr][cc] == -1) {
                            q.push(make_pair(rr, cc));
                            chk[rr][cc] = chk[r][c] + 1;
                        }
                    }
                }
                int tmp = 0;
                for (int k = 0; k < n; ++k) {
                    for (int l = 0; l < m; ++l) {
                        if (max < chk[k][l]) max = chk[k][l];
                    }
                }
            }
        }
    }

    cout << max;

    return 0;
} 
