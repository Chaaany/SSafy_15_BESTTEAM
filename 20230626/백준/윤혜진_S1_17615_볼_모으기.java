import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		char[] ball = br.readLine().toCharArray();
		
		// red, blue 총 개수 카운트
		int red = 0;
		int blue = 0;
		for (int i = 0; i < N; i++) {
			if(ball[i] == 'R') red++;
			else blue++;
		}
		
		int minR = red;
		int minB = blue;
		
		// (총 개수 - 양쪽 끝에서부터 연속된 공의 수) = 옮겨야 될 공의 개수
		// 왼쪽
		char left = ball[0];
		int r = red;
		int b = blue;
		for (int i = 0; i < N; i++) {
			if(ball[i] == left) {
				if(left == 'R') r--;
				else b--;
			}
			else {
				if(left == 'R') minR = Math.min(minR, r);
				else minB = Math.min(minB, b);
				break;
			}
		}
		
		// 오른쪽
		char right = ball[N-1];
		r = red;
		b = blue;
		for (int i = N-1; i >= 0; i--) {
			if(ball[i] == right) {
				if(right == 'R') r--;
				else b--;
			}
			else {
				if(right == 'R') minR = Math.min(minR, r);
				else minB = Math.min(minB, b);
				break;
			}
		}
		
		System.out.println(Math.min(minR, minB));
	}

}
