import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int[] nums = { 0, 1, 2 };
	static int[] choice;
	static int count;
	
	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		choice = new int[N];
		
		perm(0);
		System.out.println(count);
	}

	private static void perm(int cnt) {
		if(cnt == N) {
			String s = "";
			for(int n : choice) {
				s += n;
			}
			if(Integer.parseInt(s) % 3 == 0)
				count++;
			return;
		}
		for (int i = 0; i < 3; i++) {
			if(cnt == 0 && i == 0) continue;
			choice[cnt] = nums[i];
			perm(cnt+1);
		}
	}

}
