#include <iostream>
#include<vector>
using namespace std;

vector<vector<int>> solution(int n, vector<vector<int>> signs){
    vector<vector<int>> answer;
    int arr[100][100] = {0};

    // 플와
    // 근데 경로를 찾아야함

    for (int i = 0; i < n; ++i){
        for (int j = 0; j < n; ++j){
            if (signs[i][j] == 0) arr[i][j] = 1000;
            else arr[i][j] = 1;
        }
    }

    for (int i = 0; i < n; ++i){
        for (int j = 0; j < n; ++j){
            for (int k = 0; k < n; ++k){
                // 타고가는 경로가 더 짧으면 갱신
                if(arr[j][i] + arr[i][k] < arr[j][k]) arr[j][k] = arr[j][i] + arr[i][k];
            }
        }
    }

    // 못가는 경로는 1000이 넘을것..
    for (int i = 0; i < n; ++i){
        vector<int> tmp;
        for (int j = 0; j < n; ++j){
            if (arr[i][j] >= 1000) arr[i][j] = 0;
            else arr[i][j] = 1;
            tmp.push_back(arr[i][j]);
        }
        answer.push_back(tmp);
    }

    return answer;
}
