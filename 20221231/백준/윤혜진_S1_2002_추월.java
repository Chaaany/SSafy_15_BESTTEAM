import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		String[] enter = new String[N];
		Map<String, Integer> out = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			String car = br.readLine();
			enter[i] = car;
		}
		
		for (int i = 0; i < N; i++) {
			String car = br.readLine();
			out.put(car, out.getOrDefault(car, i));
		}
		
		int count = 0;
				
		for (String outKey : out.keySet()) {
			int start = -1;  // 들어온 순서
			int end = out.get(outKey);  // 나간 순서
			
			for (int i = 0; i < N; i++) {
				if(enter[i].equals(outKey))
					start = i;
			}
			
			// 앞에 있던 차가 뒤로 갔으면 추월한 것
			for (int i = 0; i < start; i++) {
				int otherEnd = out.get(enter[i]);
				
				if(otherEnd > end) {
					count++;
					break;
				}
			}
			
		}
		
		System.out.println(count);

	}

}
