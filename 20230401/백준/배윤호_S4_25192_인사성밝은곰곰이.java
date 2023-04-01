import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BJ_25192_GreetingBrightlyGomGome {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> hello = new HashMap<>();
		int gomgom = 0;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			if (s.equals("ENTER")) {
				hello.clear();
			} else if (hello.get(s) == null) {
				hello.put(s, 1);
				gomgom++;
			}
		}
		System.out.println(gomgom);
	}

}
