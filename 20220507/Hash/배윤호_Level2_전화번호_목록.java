import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        loop:
        for(int i=1; i<phone_book.length;i++){
            for(int j=0; j<phone_book[i-1].length(); j++){
                if(phone_book[i-1].charAt(j)!=phone_book[i].charAt(j)){
                    continue loop;
                }
            }
            answer = false;
        
        }
        return answer;
    }
}
