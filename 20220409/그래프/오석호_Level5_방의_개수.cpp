#include <string>
#include <vector>
#include <map>
#include <tuple>
#include <iostream>

using namespace std;

int dr[8] = {-1, -1, 0, 1, 1, 1, 0, -1};
int dc[8] = {0, 1, 1, 1, 0, -1, -1, -1};
map<tuple<int, int, int, int>, bool> chke;
map<tuple<int, int>, bool> chkv;

int solution(vector<int> arrows) {
    // 방이 생성되는 조건은 이미 방문한 정점에 다시 방문했을 때
    // 그리고 이미 지나가지 않은 간선일 때 (무향 그래프)
    // 그렇다면 네 점이 모두 연결되어있다면? 방이 4개 생성 - 왜? 가운데에 접점이 하나 더 생기기 때문에
    // 접점을 없애려면? 단순히 2번 움직임으로써 해결 가능
    
    int answer = 0;
    int nowR = 0;
    int nowC = 0;
    chkv[make_tuple(0, 0)] = true;
    for (int i = 0; i < arrows.size(); ++i){
        int rMove = dr[arrows[i]];
        int cMove = dc[arrows[i]];
        for (int j = 0; j < 2; ++j){
            if (chkv[make_tuple(nowR+rMove, nowC+cMove)] && !chke[make_tuple(nowR, nowC, nowR+rMove, nowC+cMove)]) answer++;
            chke[make_tuple(nowR, nowC, nowR+rMove, nowC+cMove)] = true;
            chke[make_tuple(nowR+rMove, nowC+cMove, nowR, nowC)] = true;
            chkv[make_tuple(nowR+rMove, nowC+cMove)] = true;
            nowR += rMove;
            nowC += cMove;
        }
    }
    
    return answer;
}
