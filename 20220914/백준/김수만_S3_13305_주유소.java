import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//주유소
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int stations[] = new int[N];
		int roads[] = new int[N];
		int min = Integer.MAX_VALUE;
		long ans = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N-1; i++) {
			roads[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			stations[i] = Integer.parseInt(st.nextToken());
			min = Math.min(min, stations[i]);
			ans += (long)min * (long)roads[i];
		}
		System.out.println(ans);
	}

}
