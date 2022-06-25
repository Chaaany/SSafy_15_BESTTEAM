#include <string>
#include <vector>
#include <iostream>
#include <map>
#include <algorithm>

using namespace std;

int cnt[502];
map<int, double> percentages;

// 정렬기준 bool 함수
bool cmp(const pair<int,double>& a, const pair<int,double>& b) {
	if (a.second == b.second) return a.first < b.first;
	return a.second > b.second;
}

vector<int> solution(int N, vector<int> stages) {
    // 누적합?
    vector<int> answer;
    
    // 멈춘 스테이지 세기
    for (int i = 0; i < stages.size(); ++i){
        ++cnt[stages[i]];
    }
    
    // 확률계산
    double tmp = stages.size();
    for (int i = 1; i <= N; ++i){
        if (tmp == 0) percentages[i] = 0;
        else {
            percentages[i] = cnt[i] / tmp;
            tmp -= cnt[i];
        }
    }
    
    // vector로 옮겨서 실패율이 높은 순서대로 정렬 (실패율이 같으면 앞 문제가 앞에 오도록 정렬) - cmp 사용
    vector<pair<int, double>> v(percentages.begin(), percentages.end());
    sort(v.begin(), v.end(), cmp);
    
    // 정렬 순서대로 answer에 넣기
    for (int i = 0; i < v.size(); ++i){
        answer.push_back(v[i].first);
    }
    
    return answer;
}
