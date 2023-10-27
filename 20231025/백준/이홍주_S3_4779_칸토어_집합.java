import java.io.*;
import java.util.*;

public class BJ_4779_칸토어집합 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int N = in.nextInt();
			StringBuilder sb = new StringBuilder();
			dfs(sb,N);
			
			System.out.println(sb.toString());
		}
		
	}

	private static void dfs(StringBuilder sb, int n) {
		int size = (int) Math.pow(3, n-1);
		
		if(n==0) {
			sb.append("-");
			return;
		}
		dfs(sb,n-1);
		for (int i = 0; i < size; i++) {			
			sb.append(" ");
		}
		dfs(sb,n-1);
	}



}
