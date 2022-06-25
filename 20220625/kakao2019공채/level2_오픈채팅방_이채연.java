import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> temp=new ArrayList<>();
        Map<String, String> map=new HashMap<>();    //uid - nickname
        String command, uid, nickname;
        for (int i=0; i<record.length; i++){
            String[] arr=record[i].split(" ");
            command=arr[0];
            uid=arr[1];
            if (command.equals("Enter") || command.equals("Change")){
                nickname=arr[2];
                map.put(arr[1], nickname);
            }
        }
        for (int i=0; i<record.length; i++){
            String[] arr=record[i].split(" ");
            command=arr[0];
            uid=arr[1];
            if (command.equals("Enter")){
               temp.add(map.get(uid).concat("님이 들어왔습니다."));
            }
            else if (command.equals("Leave")){
                temp.add(map.get(uid).concat("님이 나갔습니다."));
            }  
        }
        String[] answer=new String[temp.size()];
        for (int i=0; i<temp.size(); i++){
            answer[i]=temp.get(i);
        }
        
        return answer;
    }
}
