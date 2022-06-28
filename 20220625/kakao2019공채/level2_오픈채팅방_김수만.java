import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer;
        ArrayList<String> history = new ArrayList<>();
        HashMap<String, String> users = new HashMap<>();
        
        for(int i=0; i<record.length; i++){
            String input[] = record[i].split(" ");
            if(input[0].equals("Enter")){
                users.put(input[1], input[2]);
                history.add(input[1]+" In");
            }
            else if(input[0].equals("Leave")){
                history.add(input[1]+" Out");
            }
            else{
                users.put(input[1], input[2]);
            }
        }
        
        answer = new String[history.size()];
        for(int i=0; i<history.size(); i++){
            String str[] = history.get(i).split(" ");
            String uid = str[0], behavior = str[1];
            String nickname = users.get(uid);
            if(behavior.equals("In")){
                answer[i] = nickname + "님이 들어왔습니다.";
            } else{
                answer[i] = nickname + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}
