import java.util.Scanner;

public class Main_S2_11060_점프점프 {
    static int[] arr;
    static int[] dp;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        dp = new int[N];
        for(int i = 1; i < N; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        jump(0);
        if(dp[N-1] == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(dp[N-1]);
    }

    private static void jump(int n) {
        if(n == N-1 || arr[n] == 0) return;
        else {
            for (int i = 1; i <= arr[n]; i++) {
                if(n+i >= N) break;
                if (dp[n + i] > dp[n] + 1) {
                    dp[n + i] = dp[n] + 1;
                    jump(n+i);
                }
            }
        }
    }
}
