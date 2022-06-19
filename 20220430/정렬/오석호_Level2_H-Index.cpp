#include <string>
#include <vector>

using namespace std;

int solution(vector<int> citations) {
    int answer = 0;
    int size = citations.size();
    
    // 가능한 h들을 싸그리 모아서, 그 중 최댓값을 answer에 넣기
    for (int h = size; h >= 0; --h){
        int cnt = 0; // h번 이상 인용된 논문의 수
        for (int i = 0; i < size; ++i){
            if(h <= citations[i])
                ++cnt;
        }
        if(h <= cnt){
            answer = h;
            break;
        }
    }
    return answer;
}
