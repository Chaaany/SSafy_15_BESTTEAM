#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(string name) {
    int answer = 0;
    // 0. 각 알파벳을 만들기 위해 얼마나 이동해야 하는 지 구한다
    for(int i = 0; i < name.size(); ++i){
        int temp = min('Z'+1-name[i],name[i]-'A');
        answer += temp;
    }
    // 1. 왼쪽으로 가야할 지 오른쪽으로 가야할 지 정해야함
    // 왼쪽에 A가 아닌 알파벳이 더 가까운지, 오른쪽이 더 가까운지 확인해서 가까운 쪽으로 이동(greedy)
    // A만 있는 astring에서 name으로 바뀌는 것이랑
    // name에서 astring으로 바뀌는 것이랑 같으므로
    // 반대로 처리해도 같은 결과가 나옴
    // name을 call by value로 불러왔기 때문에
    // 바로 name을 바꿔도 원본에는 변화가 없다
    string astring;
    for(int i = 0; i < name.size(); i++){
        astring += 'A';
    }
    int idx = 0;
    name[0] = 'A';
    while(1){
        // 전부 A면 종료
        if(astring == name)
            return answer;
        
        // 왼쪽으로 이동
        int leftidx = idx;
        int leftcnt = 0;
        
        while(astring[leftidx] == name[leftidx]){
            leftidx--;
            leftcnt++;
            
            // 왼쪽으로 이동시에 예외사항
            if(leftidx == -1)
                leftidx = name.size()-1;
        }
        
        // 오른쪽으로 이동
        int rightidx = idx;
        int rightcnt = 0;
        
        while(astring[rightidx] == name[rightidx]){
            rightidx++;
            rightcnt++;
            
            // 오른쪽으로 이동시에 예외사항
            if(rightidx == name.size()){
                rightidx = 0;
            }      
        }
        
        // 더 적은 횟수를 가는 경우 선택(Greedy)
        // 왼쪽 선택
        if(leftcnt < rightcnt){
            answer += leftcnt;
            idx = leftidx;
        }
        // 오른쪽 선택
        else{
            answer += rightcnt;
            idx = rightidx;
        }
        name[idx] = 'A';
    }

    return answer;
}
