import java.util.*;

public class Main_G5_16928_뱀과사다리게임 {
    static int N,M;
    static int loc = 1;
    static boolean[] v = new boolean[101];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
        M = sc.nextInt();
        List<int[]> ladder = new LinkedList<>();
        List<int[]> snake = new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < N; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            ladder.add(new int[] {start,end});
        }
        for(int i = 0; i < M; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            snake.add(new int[] {start,end});
        }
        int idx1 = 0;
        int idx2 = 1;
        int[] cnt = new int[99999];
        while(true) {
            for(int dice = 6; dice > 0; dice--){
                int moveTo = loc + dice;
                int s = find(moveTo, snake);
                int l = find(moveTo, ladder);
                if(s != -1) {
                    moveTo = s;
                } else if(l != -1) {
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
    private static int find(int location, List<int[]> list) {
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i)[0] == location) return list.get(i)[1];
        }
        return -1;
    }
}