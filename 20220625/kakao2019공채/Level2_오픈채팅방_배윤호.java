import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(String[] record) {
        int count = 0;
        HashMap<String, String> user = new HashMap<>();
        for(int i =0; i<record.length; i++){
            String s = record[i];
            StringTokenizer st = new StringTokenizer(s);
            String a = st.nextToken();
            if(a.equals("Enter")){
                user.put(st.nextToken(),st.nextToken());
                count++;
            }
            else if(a.equals("Change")){
                user.replace(st.nextToken(),st.nextToken());
                count++;
            }
        }
        int index = 0;
        String[] answer = new String[count];
        ArrayList<String> result = new ArrayList<>();
        for (int i =0; i<record.length; i++ ) {
            String s = record[i];
            StringTokenizer st = new StringTokenizer(s);
            String a = st.nextToken(); 
            String id = "";
            String nick = "";
            if(a.equals("Enter")) {
                id = st.nextToken();
                nick = user.get(id);               
                result.add(nick+"님이 들어왔습니다.");
            }
            else if(a.equals("Leave")) {
                id = st.nextToken();
                nick = user.get(id);               
                result.add(nick+"님이 나갔습니다.");
            }
        }
        System.out.println(result);
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}
