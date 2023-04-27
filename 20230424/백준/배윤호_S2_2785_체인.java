import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2785_Chain {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		list.sort(null);
		int count = 0;
		while (true) {
			if (list.size() <= 1) {
				break;
			}
			list.set(0, list.get(0) - 1);
			list.remove(list.size() - 1);
			if (list.get(0) == 0) {
				list.remove(0);
			}
			count++;
		}
		System.out.println(count);
	}

}
