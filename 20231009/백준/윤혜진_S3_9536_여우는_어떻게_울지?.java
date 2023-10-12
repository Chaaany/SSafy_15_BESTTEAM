import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			ArrayList<String> sound = new ArrayList<>();
			
			String animal = "";
			while(true) {
				animal = br.readLine();
				if("what does the fox say?".equals(animal)) break;
				
				String[] word = animal.split(" ");
				sound.add(word[2]);
			}
			
			while(st.hasMoreTokens()) {
				String s = st.nextToken();
				if(!sound.contains(s))
					sb.append(s+" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
