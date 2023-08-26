import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class BJ_10827_ab {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// double, float은 부동소수점이기에 부정확
		BigDecimal under = new BigDecimal(st.nextToken());
		int over =  Integer.parseInt(st.nextToken());
		
		
		// 지수없이 변환(예제2)
		System.out.println(under.pow(over).toPlainString());
	}


}
