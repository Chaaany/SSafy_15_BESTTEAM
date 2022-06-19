import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    String[] answer;
    int idx = 1;
    boolean chk[];
    boolean fin = false;
    
    public String[] solution(String[][] tickets) {
        chk = new boolean[tickets.length + 1];
        answer = new String[tickets.length + 1];
        answer[0] = "ICN";

        Arrays.sort(tickets, (o1, o2) -> {
            if(o1[0].equals(o2[0])) return o1[1].compareTo(o2[1]);
            return o1[0].compareTo(o2[0]);
        });
        
        dfs("ICN", tickets, 1);
        
        return answer;
    }
    
    void dfs(String start, String[][] tickets, int cnt){
        // 정렬했으니 앞에서부터 순서대로 찾기
        for (int i = 0; i < tickets.length; ++i){
            if (fin == true) return; // 최단거리 찾으면 바로 종료
            if (tickets[i][0].equals(start) && chk[i] == false) {
                chk[i] = true; // 체크해놓고
                answer[cnt] = tickets[i][1]; // answer 업데이트하고
                dfs(tickets[i][1], tickets, cnt+1); // dfs 재귀로 돌리기
                chk[i] = false; // dfs가 끝나면 chk 원상복귀
            }
        }
        // 완료체크
        if (cnt == tickets.length) {
            fin = true;
            System.out.println(answer[cnt]);
            return;
        }
        
    }
    
}
