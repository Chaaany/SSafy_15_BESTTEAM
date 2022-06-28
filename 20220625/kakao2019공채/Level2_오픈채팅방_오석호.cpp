#include <string>
#include <vector>
#include <map>
#include <sstream>

using namespace std;

// 문자열 분리 함수
vector<string> split(string str, char Delimiter) {
    istringstream iss(str);
    string buffer;
 
    vector<string> result;
 
    while (getline(iss, buffer, Delimiter)) {
        result.push_back(buffer);
    }
 
    return result;
}

// 접속자의 아이디에 맞는 닉네임을 담은 map
map<string, string> m;

vector<string> solution(vector<string> record) {
    vector<string> answer;
    
    // 아이디에 맞는 닉네임 저장해두기
    for (int i = 0; i < record.size(); ++i){
        vector<string> v = split(record[i], ' ');
        
        // Enter, Change인 경우 닉네임 저장
        if (v[0] != "Leave") m[v[1]] = v[2];
    }
    
    // answer에 입퇴장 내역 저장하기
    for (int i = 0; i < record.size(); ++i){
        vector<string> v = split(record[i], ' ');
        if(v[0] == "Enter") answer.push_back(m[v[1]] + "님이 들어왔습니다.");
        else if (v[0] == "Leave") answer.push_back(m[v[1]] + "님이 나갔습니다.");
    }
    
    return answer;
}
