import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		int e = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int ns = Integer.parseInt(st.nextToken()), ne = Integer.parseInt(st.nextToken());
			
			if(e <= ns) {
				ans += (ne - ns);
				e = ne;
			}
			else if(ne > e){
				ans += (ne - e);
				e = ne;
			}
		}
		
		System.out.println(ans);
	}

}
