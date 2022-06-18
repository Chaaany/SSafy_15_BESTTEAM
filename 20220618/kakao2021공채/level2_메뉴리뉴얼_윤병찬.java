import java.util.*;
import java.io.*;

class Solution {
    static String arr[], menus[];
    static List<String> ans;
    static List<String[]> tempAns;
    static int max;
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        ans = new ArrayList<>();

        // 1. order 배열을 parsing 해서 총 알파벳 갯수 구하기
        for(int i = 0; i < orders.length; i++){
            String temp[] = orders[i].split("");
            
            for(int j = 0; j < temp.length; j++){
                lhs.add(temp[j]);
            }
        }
        
        arr = new String[lhs.size()];
        int index = 0;
        for(String str : lhs){
            arr[index++] = str;
        }
        Arrays.sort(arr);
        // 2. order 배열 알파벳, course 갯수로 nCr 구하기
        for(int i = 0; i < course.length; i++){
            tempAns = new ArrayList<>();
            max = 0;
            menus = new String[course[i]];
            nCr(0, 0, course[i], orders);
            for(int j = 0; j < tempAns.size(); j++){
                if(max == Integer.parseInt(tempAns.get(j)[1])) {
                    ans.add(tempAns.get(j)[0]);
                }
            }
        }
        
        answer = ans.toArray(new String[0]);
        Arrays.sort(answer);
        return answer;
    }
    public static void nCr(int start, int cnt, int N, String[] orders){
        if(cnt == N){
            int count = 0;
            a: for(int i = 0; i < orders.length; i++){
                for(int j = 0; j < menus.length; j++){
                    if(!orders[i].contains(menus[j])){
                        continue a;
                    }
                }

                count++;
            }
            max = Math.max(max, count);
            if(count >= 2){
                // System.out.println(max);
                tempAns.add(new String[]{String.join("", menus), ""+count});
            }
            return;
        }
        
        for(int i = start; i < arr.length; i++){
            menus[cnt] = arr[i];
            nCr(i+1, cnt+1, N, orders);
        }           

    }
}
