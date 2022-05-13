import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        
        
        StringTokenizer stz;
        
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        
        for(int i = 0; i < operations.length; i++){
            
            stz = new StringTokenizer(operations[i]);
            
            String key = stz.nextToken();
            
            int value = Integer.parseInt(stz.nextToken());
            
            if(key.equals("I")){
                
                if(tm.containsKey(value)){ // 이미 넣어져 있는 데이터
                    tm.put(value, tm.get(value)+1);
                }else{ // 새 데이터
                    tm.put(value, 1);
                };
                
                maxQ.add(value);
                minQ.add(value);
                
            }else if(key.equals("D") && value == 1) { // 최댓값 삭제
                
                if(maxQ.isEmpty())continue;
                
                while(!maxQ.isEmpty()){
                    int tmp = maxQ.poll();
                    
                    if(tm.get(tmp)==0){
                        continue;
                    }else{
                        tm.put(tmp, tm.get(tmp)-1);
                        break;
                    }
                }
                
            }else if(key.equals("D") && value == -1) { // 최솟값 삭제
                if(minQ.isEmpty())continue;
                
                while(!minQ.isEmpty()){
                    int tmp = minQ.poll();
                    if(tm.get(tmp) == 0){
                        continue;
                    }else{
                        tm.put(tmp, tm.get(tmp)-1);
                        break;
                    }
                }
            }
        }
        
        
        while(!maxQ.isEmpty()){
            int tmp = maxQ.poll();
            if(tm.get(tmp)==0){
                continue;
            }else{
                answer[0] = tmp;
                break;
            }
        }
        
         while(!minQ.isEmpty()){
            int tmp = minQ.poll();
            if(tm.get(tmp)==0){
                continue;
            }else{
                answer[1] = tmp;
                break;
            }
        }
        return answer;
    }
}
