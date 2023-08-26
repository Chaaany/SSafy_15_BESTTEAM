import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class BJ_10827_aShift6b {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigDecimal A = new BigDecimal(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		BigDecimal ans = A;
		for (int i = 0; i < b - 1; i++) {
			ans = ans.multiply(A);
		}
		System.out.println(ans.toPlainString());

	}

}
