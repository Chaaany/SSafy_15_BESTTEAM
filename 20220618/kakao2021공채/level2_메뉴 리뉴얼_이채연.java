import java.util.*;

class Solution {
    public ArrayList<String> solution(String[] orders, int[] course) {
        ArrayList<String> answer=new ArrayList<>();
        Map<String, Integer> map=new HashMap<>();
        ArrayList<ArrayList<String>> menus=new ArrayList<>(11); //최대 주문 수를 가지는 조합 저장
        for (int i=0; i<11; i++){
            menus.add(new ArrayList<>());
        }
        int[] maxCount=new int[11]; //course 별 최대 주문 수 저장
        for (int i=0; i<orders.length; i++){
            for (int j=0; j<course.length; j++){
                insertMap(orders[i], 0, 0, course[j], map, new char[course[j]]); //코스요리 수대로 map에 저장
            }
        }
        //최대값 구하기
        for (String key: map.keySet()){
            int size=key.length();
            int value=map.get(key);
            if (value<2) continue;
            if (maxCount[size]<value){
                menus.get(size).clear();
                menus.get(size).add(key);
                maxCount[size]=value;
            }
            else if (maxCount[size]==value){
                menus.get(size).add(key);
            }
        }
        //오름차순으로 넣기
        for (int i=0; i<course.length; i++){
            for (String s: menus.get(course[i])){
                answer.add(s);
            }
        }
        Collections.sort(answer);
        return answer;
    }
    public void insertMap(String order, int start, int cnt, int target, Map<String, Integer> map, char[] picked){
        if (cnt==target){
            StringBuilder k=new StringBuilder("");
            char[] temp=Arrays.copyOf(picked, picked.length);
            Arrays.sort(temp);
            for (char c: temp){
                k.append(c);
            }
            String key=k.toString();
            int value=map.containsKey(key)?map.get(key)+1:1; 
            map.put(key, value);
            return;
        }
        for (int i=start; i<order.length(); i++){
            picked[cnt]=order.charAt(i);
            insertMap(order, i+1, cnt+1, target, map, picked);
        }
    }
    
    
}
