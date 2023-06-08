import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11758_CCW {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int x3 = Integer.parseInt(st.nextToken());
		int y3 = Integer.parseInt(st.nextToken());
		int line1 = (y3 - y1) * (x2 - x1); // 1-3 기울기
		int line2 = (y2 - y1) * (x3 - x1); // 1-2 기울기
		if (line1 == line2) {
			System.out.println(0);
		} else if (line1 > line2) {
			System.out.println(1);
		} else {
			System.out.println(-1);
		}
	}

}
