import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> crane = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			crane.add(Integer.parseInt(st.nextToken()));
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		List<Integer> box = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			box.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(crane, Collections.reverseOrder());
		Collections.sort(box, Collections.reverseOrder());
		if (box.get(0) > crane.get(0)) {
			count = -1;
		} else {
			while (!box.isEmpty()) {
				int index = 0;
				for (int i = 0; i < N;) {
					if (index == box.size())
						break;
					else if (crane.get(i) >= box.get(index)) {
						box.remove(index);
						i++;
					} else
						index++;
				}
				count++;
			}
		}
		System.out.println(count);

	}

}
