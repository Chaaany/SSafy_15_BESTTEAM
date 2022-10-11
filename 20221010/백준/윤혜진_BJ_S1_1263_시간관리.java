import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] work = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			work[i][0] = Integer.parseInt(st.nextToken());
			work[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(work, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1] - o1[1];
			}
		});
				
		for (int i = 0; i < N-1; i++) {
			if(work[i][1] - work[i][0] < work[i+1][1]) 
				work[i+1][1] = work[i][1] - work[i][0];

		}
    
		
		if(work[N-1][1]-work[N-1][0] >= 0)
			System.out.println(work[N-1][1]-work[N-1][0]);
		else
			System.out.println(-1);

	}

}
