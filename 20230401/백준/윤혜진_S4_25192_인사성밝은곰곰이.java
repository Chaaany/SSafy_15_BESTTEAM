import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> hash = new HashMap<>();
		
		int count = 0;
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			if(line.equals("ENTER")) hash.clear();
			else {
				hash.put(line, hash.getOrDefault(line, 0)+1);
				if(hash.get(line) == 1) count++;
			}
		}
		
		System.out.println(count);
	}

}
