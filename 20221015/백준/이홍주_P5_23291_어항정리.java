import java.io.*;
import java.util.*;

public class BJ_23291_어항정리 {

	static int N,K;
	static int[][] map;
	static int[] place;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		place = new int[N];
		int result = 0;
		st = new StringTokenizer(br.readLine());
		
		int max=-1;
		int min=Integer.MAX_VALUE;
		for (int i = 0; i < place.length; i++) {
			place[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, place[i]);
			min = Math.min(min, place[i]);		
		}
		
		if(max-min<=K) {
			System.out.println(result);	
			return;
		}
		
		while(true) {
			result++;
			findMin();
			roll();
			move();
			moveDown();
			rollTwice();
			move();
			moveDown();
//			print();
			int diff = check();
			if(K>=diff)break;
			change();
		}
		System.out.println(result);	
	}
	
	public static void findMin() {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < place.length; i++) {
			min = Math.min(min, place[i]);
		}
		for (int i = 0; i < place.length; i++) {
			if(place[i]==min) place[i]++;
			map[N][i+1] = place[i];
		}		
	}
	
	public static void roll() {
		//어항쌓기 11 12 22 23 33 34 44 45 -> 앞에가 수평 뒤에가 수직길이			
		int idx=0;
		int start,w,h;
		start = w = h = 1;
		while(true) {
			idx++;
			if(start-1+w+h>N) break;
			for(int c=start;c<start+w;c++) {
				for(int r=N;r>N-h;r--) {
					int nr = N - w + c-start;
					int nc = start + w + N - r;
					map[nr][nc]=map[r][c];
					map[r][c] = 0;
				}
			}
			start += w;
			if(idx%2==0) w++;
			else h++;
		}
		
	}
	public static void move() {
		int[][] moveMap = new int[N+1][N+1];
		boolean[][] v = new boolean[N+1][N+1];
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map[0].length; j++) {
				if(map[i][j]!=0) {
					for (int d = 0; d < 4; d++) {
						v[i][j]=true;
						int nr = i + dr[d];
						int nc = j + dc[d];
						if(nr<=N && nc<=N && nr>0 && nc>0 && map[nr][nc]!=0 && !v[nr][nc]) {
							int D = Math.abs(map[nr][nc]-map[i][j])/5;
							if(D>0) {
								if(map[nr][nc]>map[i][j]) {
									moveMap[nr][nc]-=D;
									moveMap[i][j]+=D;									
								}else {
									moveMap[nr][nc]+=D;
									moveMap[i][j]-=D;
								}
							}
						}
					}
				}
			}
		}
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map[0].length; j++) {
				if(moveMap[i][j]!=0) {
					map[i][j] = map[i][j] + moveMap[i][j];
				}
			}
		}
	}
	
	public static void moveDown() {
		int[][] moveMap = new int[N+1][N+1];
		int right_idx = 0;
		for (int i = N; i >0; i--) {
			if(map[N-1][i]!=0) {
				right_idx = i;
				break;
			}
			moveMap[N][i]=map[N][i];
		}
		for (int i = 0; i < moveMap.length-1; i++) {
			for (int j = N; j>0; j--) {
				if(map[i][j]!=0) {
					int r = i;
					while(true) {
						if(r>N) break;
						moveMap[N][right_idx--]=map[r][j];
						map[r][j]=0;
						r++;
					}
				}
			}
		}
		for (int i = 0; i < moveMap.length; i++) {
			for (int j = 0; j < moveMap[0].length; j++) {
				map[i][j] = moveMap[i][j];
			}
		}
	}
	public static void rollTwice() {
		int half = N/2;
		for (int c = 1; c <= half; c++) {
			map[N-1][N-c+1] = map[N][c];
			map[N][c]=0;
		}
		int start = half+1;
		half/=2;
		int right_idx=N;
		for (int c = start; c < start+half; c++) {
			map[N-3][right_idx--] = map[N][c];
			map[N][c]=0;
		}
		right_idx=N;
		for (int c = start; c < start+half; c++) {
			map[N-2][right_idx--] = map[N-1][c];
			map[N-1][c]=0;
		}
	}
	public static int check() {
		int max=-1;
		int min=Integer.MAX_VALUE;
		for (int i = 1; i < map.length; i++) {
			max = Math.max(max, map[N][i]);
			min = Math.min(min, map[N][i]);
		}
		return max-min;
	}
	public static void change() {
		for (int i = 0; i < place.length; i++) {
			place[i] = map[N][i+1];
		}
	}
	public static void print() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j]+" ");
			}System.out.println();
		}
		System.out.println();
	}
}
