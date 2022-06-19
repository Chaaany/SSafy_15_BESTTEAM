import java.util.*;

class Solution {
    Set<Integer> primes=new HashSet<>();
    String numbers;
    public int solution(String temp) {
        int answer = 0;
        numbers=temp;
        for (int i=1; i<=numbers.length(); i++){    //1개~n개(number의 총 길이) 만큼 순열돌림
            perm(i,0,0, new char[i]);
        }
        return primes.size();
    }
    
    public void perm(int n, int cnt, int flag, char[] c){
        if (cnt==n){
            int digit=Integer.parseInt(new String(c));  //순열 뽑은 것 정수형으로 변경
            if (isPrime(digit)) primes.add(digit);  //소수인지 체크, 소수면 정답 Set 에 넣어줌
            return;
        }
        for (int i=0; i<numbers.length(); i++){
            if ((flag & (1<<i))>0) continue;
            c[cnt]=numbers.charAt(i);
            perm(n, cnt+1, flag | (1<<i), c);
        }
    }
    
    public boolean isPrime(int n){
        if (n==0 || n==1) return false;
        for (int i=2; i<=Math.sqrt(n); i++){    //2~sqrt(n)까지 나누어떨어지는 수 있으면 소수 아님
            if (n%i==0) return false;
        }
        return true;
    }
    
    
    
}
