import java.util.*;
class Solution {
    static int answer;
    static Set<Integer> set = new HashSet<Integer>();
    public int solution(String numbers) {
        boolean[] check = new boolean[numbers.length()];
        String newNum = "";
        for(int len = 1; len <= numbers.length(); len++) {
            ncr(numbers,check,newNum,len,0);
        }
        Integer[] numsToCheck = new Integer[set.size()];
        set.toArray(numsToCheck);
        for(int i = 0; i < numsToCheck.length; i++) {
            if(isPrime(numsToCheck[i])) answer++;
        }
        return answer;
    }
    private boolean isPrime(int x) {
        if(x == 1 || x == 0) return false;
        for(int i = 2; i < x/2+1; i++) {
            if(x % i == 0) return false;
        }
        return true;
    }
    private void ncr(String cards, boolean[] v, String num, int R, int cnt) {
        if(num.length() == R) {
            int n = Integer.parseInt(num);
            set.add(n);
            return;
        }
        for(int i = 0; i < cards.length(); i++) {
            if(v[i]) continue;
            v[i] = true;
            ncr(cards,v,num+cards.charAt(i),R,cnt+1);
            v[i] = false;
        }
    }
}