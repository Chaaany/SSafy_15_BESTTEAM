#include <string>
#include <vector>

using namespace std;

int arr[1000][1000];

vector<int> solution(int n) {
    // ++r
    // ++c
    // --r, --c
    vector<int> answer;
    int r = -1;
    int c = 0;
    int num = 0;
    for (int i = n; i > 0; i -= 3) {
        for (int j = 0; j < i; ++j) arr[++r][c] = ++num;
        for (int j = 0; j < i - 1; ++j) arr[r][++c] = ++num;
        for (int j = 0; j < i - 2; ++j) arr[--r][--c] = ++num;
    }
    
    for (int i = 0; i < n; ++i){
        for (int j = 0; j <= i; ++j) answer.push_back(arr[i][j]);
    }
    
    return answer;
}
