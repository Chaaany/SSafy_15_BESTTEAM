import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_1941_FamousSevenPrincesses {
	static char[] map;
	static int[] nums;
	static int[] c;
	static boolean[] v;
	static int answer = 0;
	static int[] dleft = { -5, 1, 5 }; //1차원 배열에서 왼쪽 줄 인접
	static int[] dcenter = { -5, 1, 5, -1 }; //오른쪽 줄 인접
	static int[] dright = { -5, 5, -1 }; //가운데 인접

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[25]; //1차원 배열로 풀거임
		v = new boolean[25];
		int index = 0;
    //1차원 배열에 입력 받는 과정
		for (int i = 0; i < 5; i++) {
			String s = br.readLine();
			for (int j = 0; j < 5; j++) {
				map[index++] = s.charAt(j);
			}
		}
    
		nums = new int[25]; // 조합 만들 때 숫자 가져올 nums 배열
		c = new int[7];  // 조합을 만들 c 배열
    //nums배열 0~24 넣기
		for (int i = 0; i < 25; i++) {
			nums[i] = i;
		}
    //조합
		combi(0, 0);

		System.out.println(answer);
	}
  
  //조합하는 함수
	private static void combi(int start, int choice) {
    //만약 7개를 다 골랐으면
		if (choice == 7) {
      //체크하러 간다.
			check();
			return;
		}
		for (int i = start; i < 25; i++) {
			v[i] = true;
			c[choice] = nums[i];
			combi(i + 1, choice + 1);
			v[i] = false;
		}

	}

	private static void check() {
    //일단 다솜파숫자 파악
		int s = 0;
		for (int i = 0; i < 7; i++) {
			if (map[c[i]] == 'S') {
				s++;
			}
		}
    //다솜파 세명 이하면 어차피 안되니까 return
		if (s < 4) {
			return;
		}
		// 다솜파 네 명 이상이면 연결 확인
		int count = 1;
		boolean[] v2 = new boolean[25];
		v2[c[0]] = true;
		Queue<Integer> que = new LinkedList<>();
		que.add(c[0]);
		while (!que.isEmpty()) {
			int cur = que.poll();
      //cur이 배열에서 어디에 위치해 있는지에 따라 다른 인접 반복문 돌리기
			if (cur % 5 == 0) {
				for (int d = 0; d < 3; d++) {
					int nd = cur + dleft[d];
					if (nd >= 0 && nd < 25 && v[nd] == true && v2[nd] == false) {
						v2[nd] = true;
						que.add(nd);
						count++;
					}
				}
			} else if (cur % 5 == 4) {
				for (int d = 0; d < 3; d++) {
					int nd = cur + dright[d];
					if (nd >= 0 && nd < 25 && v[nd] == true && v2[nd] == false) {
						v2[nd] = true;
						que.add(nd);
						count++;
					}
				}
			} else {
				for (int d = 0; d < 4; d++) {
					int nd = cur + dcenter[d];
					if (nd >= 0 && nd < 25 && v[nd] == true && v2[nd] == false) {
						v2[nd] = true;
						que.add(nd);
						count++;
					}
				}
			}
    //bfs  돌렸을 때 7명이 연결되어있다면 answer ++;
		}
		if (count == 7) {
			answer++;
		}

	}

}
