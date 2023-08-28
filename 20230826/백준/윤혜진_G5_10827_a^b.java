import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String a = st.nextToken();
		BigDecimal bigA = new BigDecimal(a);
		int b = Integer.parseInt(st.nextToken());		
		
		System.out.println(bigA.pow(b).toPlainString());
	}

}
