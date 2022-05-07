
import java.util.*;
class 이홍주_level2_전화번호목록 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        go:for(int i=0;i<phone_book.length-1;i++){
          for(int j=0;j<phone_book[i].length();j++){
                if(phone_book[i].charAt(j)!=phone_book[i+1].charAt(j)){
                    continue go;
                }
            }
            answer = false;
        }        
        return answer;
    }
}