#include <string>
#include <vector>
#include <sstream>
#include <iostream>
#include <map>
#include <algorithm>

using namespace std;

map<string, vector<int>> m;

vector<string> split(string input, char delimiter) {
    vector<string> result;
    stringstream ss(input);
    string temp;

    while (getline(ss, temp, delimiter)) {
        result.push_back(temp);
    }

    return result;
}

vector<int> solution(vector<string> info, vector<string> query) {
    vector<int> answer;
    int cnt = 0;
    for (string& s: info) {
        vector<string> tmp = split(s, ' ');
        
        // 요소 하드코딩
        vector<string> c1, c2, c3, c4;
        c1.push_back(tmp[0]);
        c1.push_back("-");
        c2.push_back(tmp[1]);
        c2.push_back("-");
        c3.push_back(tmp[2]);
        c3.push_back("-");
        c4.push_back(tmp[3]);
        c4.push_back("-");
        
        // 16가지 케이스 넣기 (tmp요소 or '-')
        for (string& s1: c1){
            for (string& s2: c2){
                for (string& s3: c3){
                    for(string& s4: c4){
                        string stmp = s1 + s2 + s3 + s4;
                        cout << stmp << endl;
                        m[stmp].push_back(stoi(tmp[4]));
                    }
                }
            }
        }  
    }
    
    // 정렬
    for (auto iter = m.begin(); iter != m.end(); ++iter){
        sort(iter->second.begin(), iter->second.end());
    }
    
    // 쿼리문 찾기
    for (string& s: query){
        vector<string> tmp = split(s, ' ');
        string target = tmp[0] + tmp[2] + tmp[4] + tmp[6];
        int targetscore = stoi(tmp[7]);
        
        // 이분탐색으로 찾기
        auto itr = lower_bound(m[target].begin(), m[target].end(), targetscore); // 정렬된 벡터에서 해당 타겟스코어 위치 찾기
        answer.push_back(m[target].size() - (itr - m[target].begin())); // 타겟 개수에서 itr 위치보다 작은 값 빼기
    }
    
    // 출력 확인용
    /*
    for (int i = 0; i < info.size(); ++i){
        cout << v[i][0] << endl;
    }
    */
    
    return answer;
}
