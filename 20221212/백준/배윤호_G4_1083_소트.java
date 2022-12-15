import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		int S = Integer.parseInt(br.readLine());
		int startIndex = 0;
		int changeIndex = 0;
		while (S > 0) {
			int max = 0;
			int size = startIndex + S + 1;
			if (size > N) {
				size = N;
			}
			for (int i = startIndex; i < size; i++) {
				if (max < list.get(i)) {
					max = list.get(i);
					changeIndex = i;
				}
			}
//			System.out.println(max + " " + changeIndex);
//			System.out.println(startIndex + "랑" + changeIndex + " 바꿀거");
			int temp = list.get(startIndex);
			list.add(startIndex, list.get(changeIndex));
			list.remove(changeIndex + 1);
//			System.out.println(list);
			S -= changeIndex - startIndex;
//			System.out.println(S);
			startIndex++;
			if (startIndex > list.size() - 1) {
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(list.get(i) + " ");
		}
		System.out.println(sb.toString().trim());

	}

}
