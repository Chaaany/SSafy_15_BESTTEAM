import java.util.*;
import java.io.*;

public class Main_S1_2529_부등호 {
    static long min = 9999999999L;
    static long max = 0L;
    static int N;
    static String[] sign;
    static int[] nums;
    static boolean[] used = new boolean[10];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sign = br.readLine().split(" ");
        nums = new int[N+1];
        go(0);
        String maxString = Long.toString(max);
        String minString = Long.toString(min);
        for(int i = 0; i < N+1-maxString.length(); i++) {
            System.out.print("0");
        }
        System.out.println(max);
        for(int i = 0; i < N+1-minString.length(); i++) {
            System.out.print("0");
        }
        System.out.println(min);
    }
    private static void go(int idx) {
        if(idx == N+1) {
//          숫자 비교 로직
            long n = Long.parseLong(Arrays.toString(nums).replaceAll("[^0-9]",""));
            if(n < min) min = n;
            else if(n > max) max = n;
            return;
        }
        for(int i = 0; i < 10; i++) {
            if(used[i]) continue;
            if(idx == 0 || checkSign(nums[idx-1], i, sign[idx-1])) {
                nums[idx] = i;
                used[i] = true;
                go(idx+1);
                used[i] = false;
            }
        }
    }

    private static boolean checkSign(int x, int y, String s) {
        if(s.equals(">")) {
            if(x > y) return true;
        } else {
            if(x < y) return true;
        }
        return false;
    }

}
