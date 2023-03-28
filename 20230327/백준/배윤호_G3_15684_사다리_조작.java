import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15684_BridgeControl {
	static int N, M, H;
	static boolean[][] v; // 사다리 놓은 위치
	static boolean check = false; // 사다리 통과 되는지?
	static int min = 4; // 그 때 갱신할 사다리 최소값

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		v = new boolean[H + 1][N + 1];
    // 사다리 입력 받기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			v[a][b] = true;
		}
    // 사다리 놓기 0개~3개까지 4개 이상은 어차피 -1 출력이므로 안해도 됨
		for (int i = 0; i <= 3; i++) {
			combi(0, i);
		}
    //여기까지 종료 안되고 왔으면 사다리 못 찾은거니까 -1 출력
  	System.out.println(-1);
	}
  //사다리를 놓는 함수
	private static void combi(int choice, int total) {

		if (choice == total) {
			find();
      // 만약 자기 자리로 내려오게 만드는 사다리 찾았으면 출력 후 종료
			if (check) {
				System.out.println(total);
				System.exit(0); // CTO 혜진씨가 알려준 스킬
			}
			return;
		}
		for (int i = 1; i < H + 1; i++) {
			for (int j = 1; j < N; j++) {
				if (v[i][j] || v[i][j - 1] || v[i][j + 1])
					continue;
				v[i][j] = true;
				combi(choice + 1, total);
				v[i][j] = false;
			}
		}
	}
  //사다리가 자기 위치로 내려오는지 체크하는 함수
	private static void find() {
		boolean can = true;
		go: for (int i = 1; i < N + 1; i++) {
			int lane = i;
			int h = 1;
			while (h < H + 1) {
        //만약 왼쪽에서 연결하는 사다리가 있으면 <로 이동 후 아래로
				if (v[h][lane - 1]) {
					h++;
					lane = lane - 1;
				} 
        //만약 자기자신에서 오른쪽 연결하는 사다리가 있으면 >로 이동 후 아래로
        else if (v[h][lane]) {
					h++;
					lane = lane + 1;
				} 
        //둘 다 사다리가 없으면 그냥 아래로
        else {
					h++;
				}
			}
      //다 내려 왔을 때 처음 시작한 사다리와 위치가 다르다면 false로 만들고 탈출
			if (lane != i) {
				can = false;
				break go;
			}
		}
    //만약 모든 사다리가 자기 위치에서 시작해서 자기 위치로 내려 왔을 경우 전역에 있는 check 변수 true
		if (can) {
			check = true;
		}
	}

}
