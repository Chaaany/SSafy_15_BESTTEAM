import java.util.*;

class Solution {
    
    private char[] menu, chosen;
    private int N, K;
    private HashMap<String, Integer> map;
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer;
        ArrayList<String> list = new ArrayList<>();
        
        //주문 메뉴를 사전순으로 정렬
        for(int i=0; i<orders.length; i++){
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = new String(arr);
        }
        
        for(int i=0; i<course.length; i++){
            K = course[i];
            chosen = new char[K];
            map = new HashMap<>();
            for(int j=0; j<orders.length; j++){
                N = orders[j].length();
                if(N < K) continue;
                menu = new char[N];
                for(int k=0; k<N; k++)
                    menu[k] = orders[j].charAt(k);
                
                combi(0,0);
            }
            
            int max = 0;
            for(String s : map.keySet()){
                if(map.get(s) < 2) continue;
                max = Math.max(max, map.get(s));
            }
            for(String s : map.keySet()){
                if(map.get(s) == max)
                    list.add(s);
            }
        }
        
        answer = new String[list.size()];
        for(int i=0; i<list.size(); i++)
            answer[i] = list.get(i);
        Arrays.sort(answer);
        
        return answer;
    }
    
    private void combi(int start, int cnt){
        if(cnt == K){
            String str = new String(chosen);
            map.put(str, map.getOrDefault(str, 0)+1);
            return;
        }
        
        for(int i=start; i<N; i++){
            chosen[cnt] = menu[i];
            combi(i+1, cnt+1);
        }
    }
}
