#include <string>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;

int cnt[27]; // 조합 길이별 최대 주문 횟수
map<string,int> m; // 해당 조합이 등장한 횟수
vector<string> menu[27][21]; // 길이가 i고 j번 주문된 조합 목록

void comb(string order, int start, string dish){
    if(dish.size() > 1){ // 2번 이상만 추가
        if (cnt[dish.size()] == m[dish]) ++cnt[dish.size()]; // 기존 최대값과 같은데 1을 더해야하는 경우 cnt 최신화
        ++m[dish]; // 맵에 해당 조합 추가
        menu[dish.size()][m[dish]].push_back(dish); // 분류별 조합 목록 추가
    }
    
    // DFS로 모든 조합 챙기기
    for(int i = start; i < order.size(); ++i) {
        dish.push_back(order[i]);
        comb(order, i + 1, dish);
        dish.pop_back();
    }
}
vector<string> solution(vector<string> orders, vector<int> course) {
    vector<string> answer;

    // 모든 조합 DFS
    for(string& order: orders) {
        sort(order.begin(), order.end()); // 순서만 다르고 중복된 조합이 나오지 않도록 정렬
        comb(order, 0, "");
    }

    // 많이 나온 조합만 answer에 push하기
    for(int i: course) {
        if(cnt[i] > 1) {
            for(string s: menu[i][cnt[i]]) {
                answer.push_back(s);
            }
        }
    }

    // 정렬하기
    sort(answer.begin(), answer.end());

    return answer;
}
