import java.io.*;
import java.util.*;

public class BJ_25192_인사성밝은곰곰이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashSet<String> set = new HashSet<>();
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		for (int i = 0; i < N; i++) {
			String now = br.readLine();
			
			if(now.equals("ENTER")) {
				answer += set.size();
				set = new HashSet<>();
				continue;
			}
			set.add(now);
		}
		answer += set.size();
		System.out.println(answer);
	}

}
