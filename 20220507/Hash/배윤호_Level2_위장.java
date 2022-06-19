import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        int count = 1;
        List<Integer> list = new ArrayList<>();
        List <String> type = new ArrayList<>();
        for(int i=0; i<clothes.length;i++){
            type.add(clothes[i][1]);
        }
        Collections.sort(type);
        for(int i=0; i<type.size();i++){
            if(i==type.size()-1){
                list.add(count);
                break;
            }
            if(type.get(i).equals(type.get(i+1))){
                count++;
            }
            else{
                list.add(count);
                count =1;             
            }
            
        } 
        System.out.println(type);
        System.out.println(list);
        for(int i=0; i < list.size(); i++){
            answer *= list.get(i)+1;
        }
        answer -=1;
        return answer;
    }
}
