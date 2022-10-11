import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		List<Work> workList = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			int deadline = Integer.parseInt(st.nextToken());
			workList.add(new Work(time, deadline));
		}
		Collections.sort(workList);

		int endTime = workList.get(0).deadline - workList.get(0).time;
		for (int i = 1; i < workList.size(); i++) {
			if (workList.get(i).deadline < endTime) {
				endTime = workList.get(i).deadline;
			}
			endTime -= workList.get(i).time;
		}
		if (endTime > 0) {
			System.out.println(endTime);
			;
		} else {
			System.out.println("-1");
		}
	}

	public static class Work implements Comparable<Work> {
		int time;
		int deadline;

		Work(int time, int deadline) {
			this.time = time;
			this.deadline = deadline;
		}

		@Override
		public int compareTo(Work o) {
			return o.deadline - this.deadline;

		}
	}

}
