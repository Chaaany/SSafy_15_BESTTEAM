package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



/**
 * @author Ben
 *- 입력
 *- root 배열 초기화
 *- root 찾기
 *- root 기준으로 연결되어 있는지 여행 계획 대로 판단하기
 *- root가 같을 경우 YES, 다를 경우 NO
 */
public class 윤병찬_G4_1976_여행_가자 {
	static int N, root[], rank[], M, plan[], v[][];
	static String answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		root = new int[N+1];
		rank = new int[N+1];
		plan = new int[M];
		v = new int[N+1][N+1];
		
		initRoot(); // root배열 초기화
		
		// 입력 (양방향 연결)
		for (int i = 0; i < N; i++) {
			String temp[] = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				v[i+1][j+1] = Integer.parseInt(temp[j]);
			}
		}
		
		// 입력 (여행 계획)
		stz = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			plan[i] = Integer.parseInt(stz.nextToken());
		}
		
		// root mapping
		for(int i = 1; i <= N; i++ ) {
			for(int j = 1; j <= N; j++) {
				if(v[i][j] == 0)continue;
				makeRoot(i, j);
			}
		}
		answer = "NO";
		// 여행 가능 여부 판단
		canTrip();
		
		System.out.print(answer);
	}
	
	private static void canTrip() {
		for (int i = 0; i < M - 1; i++) {
			if(root[plan[i]] != root[plan[i+1]]) {
				return;
			}
		}
		answer = "YES";
	}

	private static void makeRoot(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a == b) return;

		if(rank[a] >= rank[b]) {
			rank[a]++;
			root[b] = a;
		} else {
			rank[b]++;
			root[a] = b;
		}
	}

	private static int find(int a) {
		if(a == root[a]) return a;
		
		return root[a] = find(root[a]);
	}

	private static void initRoot() {
		for (int i = 1; i <= N; i++) {
			root[i] = i;
		}
	}
}
