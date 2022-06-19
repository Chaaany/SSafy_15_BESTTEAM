import java.io.*;
import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String arr[] = new String[numbers.length];
        
        for(int i = 0; i < numbers.length;i++){
            arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String a, String b) {
                return Integer.parseInt(a+b) - Integer.parseInt(b+a);
            }
        });
        int cnt = 0;
        for(int i = numbers.length-1; i >= 0;i--){
            answer += arr[i];
            if(arr[i].equals("0"))cnt++;
        }
        if(cnt == numbers.length)answer = "0";

        return answer;
    }
}
