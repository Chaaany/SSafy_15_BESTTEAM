import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//사다리 타기
public class Main {

	static int k, n, t; //t: 타겟 라인 넘버
	static String horizontal[];
	static int ans[];
	static char[] res; //출력할 정답
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		horizontal = new String[n];
		res = new char[k-1];
		String ansStr = br.readLine();
		ans = new int[k];
		for(int i=0; i<k; i++) {
			ans[i] = ansStr.charAt(i)-'A';
		}
		for(int i=0; i<n; i++) {
			horizontal[i] = br.readLine();
			if(horizontal[i].charAt(0) == '?')
				t = i;
		}
		
		if(!dfs(0)) {
			for(int i=0; i<k-1; i++)
				res[i] = 'x';
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<res.length; i++)
			sb.append(res[i]);
		System.out.println(sb.toString());
	}

	// N < 2^14 -> 정답 찾으면 종료하는 완전 탐색
	private static boolean dfs(int loc) {
		if(loc == k-1) {
			//정답인지 확인
			if(check()) 
				return true;
			return false;
		}
		
		if(loc == 0 || (loc>=1 && res[loc-1] != '-')) {
			res[loc] = '-';
			if(dfs(loc+1)) return true;
			res[loc] = '*';
		}
		res[loc] = '*';
		if(dfs(loc+1)) return true;
		
		return false;
	}
	
	private static boolean check() {
		String tmp[] = horizontal;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<res.length; i++) {
			sb.append(res[i]);
		}
		tmp[t] = sb.toString();
		
		for(int i=0; i<k; i++) {
			int cur = i;
			for(int j=0; j<n; j++) {
				if(cur >= 1 && tmp[j].charAt(cur-1) == '-')
					cur--;
				else if(cur < k-1 && tmp[j].charAt(cur) == '-')
					cur++;
			}
			if(ans[cur] != i)
				return false;
		}
		return true;
	}
}
