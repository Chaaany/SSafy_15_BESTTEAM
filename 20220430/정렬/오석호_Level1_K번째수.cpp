#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    
    for(int i = 0; i < commands.size(); ++i){
        vector<int> temp;
        for (int j = commands[i][0]-1; j < commands[i][1]; ++j) // 1. array에서 필요한 부분 잘라냄
            temp.push_back(array[j]);
        sort(temp.begin(), temp.end()); // 2. 정렬한다
        answer.push_back(temp[commands[i][2]-1]); // 3. 인덱싱해서 answer에 넣는다
    }
    
    return answer;
}
