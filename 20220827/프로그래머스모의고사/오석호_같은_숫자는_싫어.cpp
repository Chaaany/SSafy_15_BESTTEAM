#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> answer;
    int tmp = arr[0];
    for (int i = 1; i < arr.size(); ++i){
        if (tmp == arr[i]) continue;
        else {
            answer.push_back(tmp);
            tmp = arr[i];
        }
    }

    if (arr.size()) {
        answer.push_back(tmp);
    }

    return answer;
}
