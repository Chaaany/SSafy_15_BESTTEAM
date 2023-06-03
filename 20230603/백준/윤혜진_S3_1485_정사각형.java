import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int[][] dot = new int[4][2];
			ArrayList<Double> line = new ArrayList<>();
			
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				dot[i][0] = x;
				dot[i][1] = y;
				
				for (int j = 0; j < i; j++) {
					int px = dot[j][0];
					int py = dot[j][1];	
					line.add(Math.sqrt(Math.pow(x-px, 2)+Math.pow(y-py, 2)));
				}
			}
			
			Collections.sort(line);
			
			boolean check = true;
			for (int i = 1; i < 4; i++) {
				if(!line.get(i).equals(line.get(i-1))) check = false;
			}
			if(!line.get(4).equals(line.get(5))) check = false;
			
			sb.append(check?"1\n":"0\n");
		}
		
		System.out.println(sb);
	}

}
