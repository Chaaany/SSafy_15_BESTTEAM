#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> numbers) {
    // 브루트포스 O(n^2)
    vector<int> answer;
    
    // 무지성 브루트포스 더하기
    for (int i = 0; i < numbers.size(); ++i){
        for (int j = 0; j < numbers.size(); ++j) if (i != j) answer.push_back(numbers[i] + numbers[j]);
    }
    
    // 정렬 후 중복제거
    sort(answer.begin(), answer.end());
    answer.erase(unique(answer.begin(), answer.end()), answer.end());
    
    return answer;
}
