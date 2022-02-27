import java.util.HashSet;
import java.util.Iterator;

class Solution {
    static HashSet<Integer> al = new HashSet<>();
    static int N;
    static boolean[] chk;
    static char[] nums;
    static HashSet<Integer> s = new HashSet<>();
    
    public static int solution(String numbers) {
        char[] charNums = numbers.toCharArray();
        N = numbers.length();
        chk = new boolean[N];
        
        // 모든 경우의 수를 담은 set 완성하기
        for (int i = 1; i <= N; ++i){
            nums = new char[i];
            perm(i, 0, charNums);
        }
        
        // 소수 확인하기
        int answer = 0;
        Iterator iter = s.iterator();
        while(iter.hasNext()){
            if(chkPrime((int)iter.next())) answer++;
        }
        
        return answer;
    }
    
    // 소수판별
    public static boolean chkPrime(int n){
        if (n == 0 || n == 1) return false;
        
        for (int i = 2; i * i <= n; ++i){
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    // 순열
    public static void perm(int R, int cnt, char[] c){
        if(cnt == R){
            s.add(Integer.parseInt(new String(nums)));
            return;
        }
        for (int i = 0; i < N; ++i) {
			if(chk[i]) continue;
			chk[i] = true;
			nums[cnt] = c[i];
			perm(R, cnt+1, c);
			chk[i] = false;
		}
    }
}
