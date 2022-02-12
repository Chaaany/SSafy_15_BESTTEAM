import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ_1715_카드정렬 {
	static int N;
	static int[] arr;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			pq.add(in.nextInt());
		}
		long sum=0;
		while(pq.size()>1) {
			int x=pq.poll();
			int y=pq.poll();
			
			sum+=x+y;
			pq.add(x+y);							
		}
		System.out.println(sum);
	}
}
