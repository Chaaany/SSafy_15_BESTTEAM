import java.util.*;

class Solution {
    static Map<String, Integer> map = new HashMap<>();
    static char[] choice;
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        // 조합
        for(String order : orders) {
            for(int num : course) {
                choice = new char[num];
                // 문자열 정렬 후 조합 돌리기
                char[] or = order.toCharArray();
                Arrays.sort(or);
                combi(0, 0, num, String.valueOf(or));
            }
        }
        
        // course별 max값 구하기
        ArrayList<String> list = new ArrayList<>();
		for(int c : course) {
        	int max = 0;
            // max값 구하기
        	for(String key: map.keySet()) {
            	if(key.length()==c && map.get(key) > 1) {
            		if(map.get(key) > max) {
            			max = map.get(key);
            		}
            	}

            }
            
            // max값에 해당하는 문자열 넣기
        	for(String key: map.keySet()) {
            	if(key.length()==c && map.get(key) == max) {
            		list.add(key);
            	}

            }
        }
    
        answer = new String[list.size()];
        int idx = 0;
        for (int i = 0; i < list.size(); i++) {
        	answer[idx] = list.get(i);
        	idx++;
		}
        
        // 정렬
        Arrays.sort(answer);
        
        return answer;
    }
    
    static public void combi(int start, int cnt, int num, String order) {
        if(cnt == num) {
            String key = String.valueOf(choice);
            map.put(key, map.getOrDefault(key, 0)+1);
            return;
        }
        for(int i = start; i < order.length(); i++) {
            choice[cnt] = order.charAt(i);
            combi(i+1, cnt+1, num, order);
            
        }
    }    
    
}
