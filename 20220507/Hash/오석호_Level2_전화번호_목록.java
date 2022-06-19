import java.lang.*;
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
        // 정렬하면 붙어있는 요소만 확인하면 된다!
        for (int i = 0; i < phone_book.length - 1; ++i){
            boolean chk = true;
            for (int j = 0; j < phone_book[i].length(); ++j){
                if (phone_book[i].charAt(j) != phone_book[i+1].charAt(j)) {
                    chk = false;
                    break;
                }
            }
            if (chk) answer = false;
            if (!answer) break;
        }
        
        return answer;
    }
}
