import java.util.*;
import java.io.*;

class Solution {
    static int delta[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int solution(int[][] maps) {
        int answer = 0;

        int targetR = maps.length - 1;
        int targetC = maps[0].length - 1;

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0});
        int cnt = 1;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){

                int temp[] = q.poll();
                int r = temp[0];
                int c = temp[1];

                for(int j = 0; j < delta.length; j++){
                    int nr = r + delta[j][0];
                    int nc = c + delta[j][1];


                    if(!(0 <= nr && nr < maps.length && 0 <= nc && nc < maps[0].length)) continue;

                    if(maps[nr][nc] == 1){
                        if(nr == targetR && nc == targetC){
                            answer = cnt + 1;
                        }
                        maps[nr][nc] = 0;
                        q.add(new int[]{ nr, nc });
                    }
                }
            }
            cnt++;
        }

        if(answer == 0)answer = -1;

        return answer;
    }
}
