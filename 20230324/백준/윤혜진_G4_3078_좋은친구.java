import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] students = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			students[i] = br.readLine().length();
		}

		// 이름길이 별로 큐 생성
		Queue<Integer>[] arr = new LinkedList[21];
		for (int i = 1; i < 21; i++) {
			arr[i] = new LinkedList<>();
		}		
		
		long count = 0;
		for (int i = 1; i <= N; i++) {
			int len = students[i];
			
			if(arr[len].isEmpty()) arr[len].add(i);
			else {
				// 큐에 좋은친구만 남도록. 등수 차이가 K 이상이면 poll
				while(!arr[len].isEmpty() && i - arr[len].peek() > K) {
					arr[len].poll();
				}

				count += arr[len].size();
				arr[len].add(i);
			}
		}
		
		System.out.println(count);
	}

}
