import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1485_정사각형 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			dot a = new dot(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
			st = new StringTokenizer(br.readLine());
			dot b = new dot(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
			st = new StringTokenizer(br.readLine());
			dot c = new dot(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
			st = new StringTokenizer(br.readLine());
			dot d = new dot(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
			check(a, b, c, d);
		}
	}

	private static void check(dot a, dot b, dot c, dot d) {
		long[] l = new long[6];
		l[0] = (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
		l[1] = (b.x - c.x) * (b.x - c.x) + (b.y - c.y) * (b.y - c.y);
		l[2] = (c.x - d.x) * (c.x - d.x) + (c.y - d.y) * (c.y - d.y);
		l[3] = (d.x - a.x) * (d.x - a.x) + (d.y - a.y) * (d.y - a.y);
		l[4] = (a.x - c.x) * (a.x - c.x) + (a.y - c.y) * (a.y - c.y);
		l[5] = (b.x - d.x) * (b.x - d.x) + (b.y - d.y) * (b.y - d.y);
		Arrays.sort(l);
		if (l[0] == l[1] && l[1] == l[2] && l[2] == l[3] && l[4] == l[5]) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}

	}

	public static class dot {
		long x;
		long y;

		dot(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}

}
