import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		if(X == Y) {
			System.out.println(0);
			return;
		}
		
		X++;
		int ans = 1, last = 1;
		while(X != Y){
			if(last*(last-1)/2 == Y-X) {
				ans += last-1;
				break;
			}
			else {
				if(last*(last+1)/2+(last+1) <= Y-X)
					last++;
				else if(last*(last-1)/2+last <= Y-X);
				else last--;
			}
			X += last;
			ans++;
		}
		System.out.println(ans);
	}

}
