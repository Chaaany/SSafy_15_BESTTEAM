import java.util.*;

public class Boj_16928 {
    static int N,M, ladder[], snake[];
    static int loc = 1;
    static boolean[] v = new boolean[101];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
        M = sc.nextInt();
        ladder = new int[107];
        snake = new int[107];
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < N; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            ladder[start] = end;
        }
        for(int i = 0; i < M; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            snake[start] = end;
        }
        int idx1 = 0;
        int idx2 = 1;
        int[] cnt = new int[99999];
        while(true) {
            for(int dice = 6; dice > 0; dice--){
                int moveTo = loc + dice;
                int s = snake[moveTo];
                int l = ladder[moveTo];
                if(s != 0) {
                    moveTo = s;
                } else if(l != 0) {
                    moveTo = l;
                }
                
                if(moveTo <= 100) {
                    if(v[moveTo] == false){
                        v[moveTo] = true;
                        q.add(moveTo);
                        cnt[idx2++] = cnt[idx1] + 1;
                    }
                }
            }
            loc = q.poll();
            idx1++;
            if(loc == 100) break;
        }
        System.out.println(cnt[idx1]);
	}
}
