import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] nums, choice;
	static StringBuilder sb = new StringBuilder();
	static HashSet<String> set = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		choice = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		
		perm(0);
		System.out.println(sb);
	}

	private static void perm(int cnt) {
		if(cnt == M) {
			if(set.contains(Arrays.toString(choice))) return;
			
			for (int i = 0; i < M; i++) {
				sb.append(choice[i]+" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
			set.add(Arrays.toString(choice));
			return;
		}
		for (int i = 0; i < N; i++) {
			choice[cnt] = nums[i];
			perm(cnt+1);
		}
	}

}
