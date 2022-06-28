import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[][] failpercent = new int[N+3][2]; //[0]번 = 실패자 [1]번 시도자
        float[] fail = new float[N+1];
        float[] sorted = new float[N+1];
        float[] sort = new float[N+1];
        boolean[] v = new boolean[N+1];
        for(int i=0; i<failpercent.length; i++){
            failpercent[i][1]=stages.length;
        }
        
        for(int i=0; i<stages.length; i++){
            int temp = stages[i];
            failpercent[temp][0]++;
            for(int j=temp+1; j<failpercent.length; j++){
                failpercent[j][1]--;
            }                
        }
        for(int i =1; i<N+1; i++){
            if(failpercent[i][1]==0){
                fail[i]=0;
            }
            else{
                fail[i] = (float)failpercent[i][0]/(float)failpercent[i][1];
            }
            
        }
        
        
        // for(int i=0; i<failpercent.length; i++){
        //     for(int j=0; j<2; j++){
        //         System.out.print(failpercent[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        for(int i=1; i<N+1; i++){
            sorted[i] = fail[i];
        }
        Arrays.sort(sorted);
        for(int i=1; i<N+1; i++){
            sort[i] = sorted[N+1-i];
        }
        
        for(int j=1; j<N+1; j++){
            System.out.print(sort[j]+" ");
        }
        for(int i=0; i<N; i++){
            go:
            for(int j=1; j<sort.length; j++){
                float temp = sort[j];
                for(int k=1; k<fail.length; k++){
                    if(v[k]) continue;
                    if(temp==fail[k]){
                        v[k] = true;
                        answer[i] = k;
                        break go;
                    }
                }
            }
        }
        return answer;
    }
}
