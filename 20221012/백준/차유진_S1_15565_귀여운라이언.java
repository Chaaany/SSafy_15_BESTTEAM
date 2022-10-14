import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main_15565 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int min = Integer.MAX_VALUE;
		List<Integer> list = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			if(arr[i] == 1) {
				list.add(i);
			}
			if(list.size() == K) {
				min = Math.min(min, list.get(K-1) - list.get(0) + 1);
				list.remove(0);
			}
		}
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
		sc.close();
	}
}
