#include<vector>
#include<iostream>
#include<algorithm>
#include<queue>
using namespace std;

int solution(int no, vector<int> works) {
    int answer = 0;

    // 예외처리
    int test = 0;
    for (int i = 0; i < works.size(); ++i) test += works[i];
    if (test < no) return 0;

    // 우선순위큐?
    priority_queue<int> pq;

    for(int i = 0; i < works.size(); ++i) pq.push(works[i]);

    while(no){
        int tmp = pq.top();
        --tmp;
        pq.pop();
        pq.push(tmp);
        --no;
    }

    while (!pq.empty()) {
        answer += pq.top() * pq.top();
        pq.pop();
    }

    return answer;
}
