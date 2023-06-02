import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K;
	static int[] conveyor, robot;
	static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		conveyor = new int[2*N];
		robot = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2*N; i++) {
			conveyor[i] = Integer.parseInt(st.nextToken());
		}
		
		while(check()) {
			// 벨트, 로봇 한 칸 회전
			rotate();
			// 로봇 이동
			move();
			// 로봇 올리기
			robot();
			count++;
		}
		
		System.out.println(count);
	}

	private static void rotate() {
		// 벨트 한 칸 회전
		int temp = conveyor[2*N-1];
		for (int i = 2*N-1; i > 0; i--) {
			conveyor[i] = conveyor[i-1];
		}
		conveyor[0] = temp;
		
		// 로봇 한 칸 회전
		for (int i = N-1; i > 0; i--) {
			robot[i] = robot[i-1];
		}
		robot[0] = 0;  // 회전하면서 N-1번칸 내리고, 0번칸은 비어있게됨
	}

	private static void move() {
		robot[N-1] = 0;
		for (int i = N-2; i >= 0; i--) {
			if(robot[i] == 1) {
				if(robot[i+1] == 0 && conveyor[i+1] >= 1) {
					robot[i+1] = 1;
					robot[i] = 0;
					conveyor[i+1]--;
				}
			}
		}	
	}

	private static void robot() {
		if(conveyor[0] > 0 && robot[0] == 0) {
			robot[0] = 1;
			conveyor[0]--;
		}
	}

	private static boolean check() {
		int cnt = 0;
		for (int i = 0; i < 2*N; i++) {
			if(conveyor[i] == 0) cnt++;
		}
		return cnt<K?true:false;
	}
}
