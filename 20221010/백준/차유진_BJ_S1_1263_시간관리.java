import java.util.*;

public class Main_1263 {
	static int N;
	static int[][] arr;
	static final int MAXTIME = 1000000;
	static boolean[] timeline = new boolean[MAXTIME];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1]-o1[1];
			}
			
		});
		
		for (int i = 0; i < N; i++) {
			if(!assignTime(arr[i][1], arr[i][0])) {
				System.out.println(-1);
				return;
			}
		}
		
		for (int i = 0; i < MAXTIME; i++) {
			if(timeline[i]) {
				System.out.println(i);
				break;
			}
		}
		sc.close();
	}

	private static boolean assignTime(int endTime, int workHour) {
		int startTime = endTime - workHour;
		if(startTime < 0) return false;
		if(timeline[endTime-1] == true) {
			assignTime(endTime - 1, workHour);
		}
		for (int i = 0; i < workHour; i++) {
			timeline[startTime+i] = true;
		}
		return true;
	}

}
