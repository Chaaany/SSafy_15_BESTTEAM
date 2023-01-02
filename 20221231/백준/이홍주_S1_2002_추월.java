import java.io.*;
import java.util.*;

public class BJ_2002_추월 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<String> list = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) {
			String str = br.readLine().trim();
			list.add(str);
		}
		
		int count = 0;
		
		for (int i = 1; i <= N; i++) {
			String now = br.readLine().trim();
			
			if(!list.get(0).equals(now)) count++;
			list.remove(now);
		}		
		System.out.println(count);
	}
}
