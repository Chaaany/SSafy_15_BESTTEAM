#include <string>
#include <vector>

using namespace std;

int solution(vector<int> a) {
    // 아이디어 - 해당 풍선의 좌우에 모두 자신보다 작은 풍선이 있다면 불가능
    // 좌측부터 최솟값 연속해서 적기, 우측부터 최솟값 연속해서 적기
    // 그 후 해당 인덱스의 벡터값들을 비교해서 모두 자신보다 작은게 아니라면 result에 1을 더해줌
    // 투 포인터..?

    int leftmin = 1000000001;
    int rightmin = 1000000001;
    bool isSmall[1000000] = {0};
    
    // 앞뒤로 한번씩 돌리기
    for (int i = 0; i < a.size(); ++i){
        if (a[i] < leftmin) {
            isSmall[i] = true;
            leftmin = a[i];
        }
    }
    
    for (int i = a.size()-1; i >= 0; --i){
        if (a[i] < rightmin) {
            isSmall[i] = true;
            rightmin = a[i];
        }
    }
    
    // true 개수 찾기
    int answer = 0;
    
    for (int i = 0; i < a.size(); ++i){
        if(isSmall[i]) ++answer;
    }
    
    return answer;
}
