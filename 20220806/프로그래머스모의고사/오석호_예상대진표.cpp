#include <iostream>

using namespace std;

int solution(int n, int a, int b){
    int answer = 0;
    --a;
    --b;
    while(a != b){
        ++answer;
        a /= 2;
        b /= 2;
    }
    return answer;
}
