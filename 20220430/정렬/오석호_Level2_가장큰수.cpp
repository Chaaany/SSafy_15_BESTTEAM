#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp(string &a, string &b){
    return a+b > b+a;
}

string solution(vector<int> numbers) {
    string answer = "";
    vector<string> numb;
    string chk = "";
    for(int i = 0; i < numbers.size(); ++i)
        numb.push_back(to_string(numbers[i]));
    sort(numb.begin(), numb.end(), cmp);
    for (int i = 0; i < numb.size(); ++i)
        answer += numb[i];
    for (int i = 0; i < numb.size(); ++i)
        chk += "0";
    if (chk == answer)
        answer = "0";
         
    return answer;
}
