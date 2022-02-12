import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_G4_1715_카드정렬하기 {
	static int N;
	static int cnt;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			pq.add(sc.nextInt());
		}
		int a = 0;
		int b = 0;
		while(N > 1) {
			a = pq.peek();
			pq.poll();
			N--;
			b = pq.peek();
			pq.poll();
			N--;
			cnt += (a+b);
			pq.add(a+b);
			N++;
		}
		System.out.println(cnt);
		sc.close();
	}
}
