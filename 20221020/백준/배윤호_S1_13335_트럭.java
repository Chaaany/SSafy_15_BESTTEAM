import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] trucks = new int[n];
		int index = 0;
		int totalWeight = 0;
		int time = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			trucks[i] = Integer.parseInt(st.nextToken());
		}
		Queue<Integer> bridge = new LinkedList<>();
		while (index < n) {
			time++;
			if (L >= totalWeight + trucks[index]) {
				bridge.add(trucks[index]);
				totalWeight += trucks[index];
				index++;
			} else {
				bridge.add(0);
			}
			if (bridge.size() == w) {
				int arrive = bridge.poll();
				totalWeight -= arrive;
			}
		}
		time += w;
		System.out.println(time);
	}

}
