import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int a = Integer.parseInt(st.nextToken());
			arr[i] = a==1?true:false;
		}
		
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if(gender == 1) {
				for (int j = num; j <= N; j+=num) {
					arr[j]  = !arr[j];
				}
			}
			else if (gender == 2) {
				arr[num] = !arr[num];
				
				int left = num-1;
				int right = num+1;
				while(true) {
					if(left < 1 || right > N || arr[left] != arr[right]) {
						break;
					}
					arr[left] = !arr[left];
					arr[right] = !arr[right];
					
					left--;
					right++;
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if(arr[i]) sb.append("1 ");
			else sb.append("0 ");
			
			if(i%20 == 0) {
				sb.setLength(sb.length()-1);
				sb.append('\n');
			}
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}
