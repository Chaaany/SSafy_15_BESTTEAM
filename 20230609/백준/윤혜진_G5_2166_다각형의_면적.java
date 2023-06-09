import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 참고 : https://wogud6792.tistory.com/12

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		long[][] dot = new long[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			dot[i][0] = Long.parseLong(st.nextToken());
			dot[i][1] = Long.parseLong(st.nextToken());
		}

		double width = 0;
		for (int i = 1; i < N-1; i++) {
			width += (((dot[0][0]*dot[i][1]) + (dot[i][0]*dot[i+1][1]) + (dot[i+1][0]*dot[0][1]))
					- ((dot[0][1]*dot[i][0]) + (dot[i][1]*dot[i+1][0]) + (dot[i+1][1]*dot[0][0])));
		}

		width = Math.abs(width);
		width /= 2;
		
		System.out.printf("%.1f", width);
	}

}
