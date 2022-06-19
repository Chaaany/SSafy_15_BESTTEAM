import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int answer = 0;
		
		n = sc.nextInt();
		
		for (int i = 0; i < n; ++i) {
			int tmp = sc.nextInt();
			pq.add(tmp);
		}
		
		while(pq.size() != 1) {
			int tmp1 = pq.poll();
			int tmp2 = pq.poll();
			int sum = tmp1 + tmp2;
			answer += sum;
			pq.add(sum);
		}
		
		System.out.println(answer);
	}
}
