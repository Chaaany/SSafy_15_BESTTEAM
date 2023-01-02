import java.io.*;
import java.util.*;

public class Main_S4_20937_떡국 {
	
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] bowl = new int[N];
        int[] cnt = new int[50001];
        for(int i = 0; i < N; i++) {
            bowl[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < N; i++) {
        	cnt[bowl[i]]++;
        }
        int ans = Arrays.stream(cnt).max().getAsInt();
        System.out.println(ans);
    }
}
