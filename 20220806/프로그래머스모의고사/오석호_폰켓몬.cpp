#include <vector>
#include <set>
#include <algorithm>
using namespace std;

int solution(vector<int> nums) {
    set<int> s;
    for (int i = 0; i < nums.size(); ++i) s.insert(nums[i]);
    return min(nums.size() / 2, s.size());
}
