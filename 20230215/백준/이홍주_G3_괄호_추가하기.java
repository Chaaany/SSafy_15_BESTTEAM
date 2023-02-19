import java.io.*;

// dfs + 완탐(N이 19밖에 안됨)
// dp는 음수 최소 * 음수 최소가 최대가 되는 경우가 있어 안좋은방법인 듯
/* 
dp 반례
19
2*1-1*1+2*2-9*8-9*9
답: 189
*/
public class BJ_16637_괄호추가하기 {

	static long N, max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String str = br.readLine().trim();
		
		// 음수가 최대가 될 수 있음
		max = Long.MIN_VALUE;
		
		dfs(str, 0, Long.parseLong(str.charAt(0)+""), 0);
		
		System.out.println(max);
	}


	private static void dfs(String str, int i, long count, long before) {
		if(i==N-1) {
			max = Math.max(max, count);
			return;
		}
		
		// 차례대로
		dfs(str, i+2, Calc(count, str.charAt(i+1), Long.parseLong(str.charAt(i+2)+"")), count);
		// 괄호
		if(i>1) dfs(str, i+2, Calc(before, str.charAt(i-1), Calc(Long.parseLong(str.charAt(i)+""), str.charAt(i+1), Long.parseLong(str.charAt(i+2)+""))), count);		
	}


	private static long Calc(long a, char between, long b) {
		if(between == '+') return a+b;
		else if(between =='-') return a-b;
		else return a*b;
	}

}
