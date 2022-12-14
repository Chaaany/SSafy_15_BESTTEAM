import java.io.*;
import java.util.*;

public class Main {
	
	static int[] dr = {0,1,1,1,0,0,0,-1,-1,-1};
	static int[] dc = {0,-1,0,1,-1,0,1,-1,0,1};

	static int R,C,sr,sc;
	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R =  Integer.parseInt(st.nextToken());
		C =  Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		ArrayList<int[]> arduino = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			char[] cs = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = cs[j];
				if(map[i][j]=='I') {
					sr = i;
					sc = j;
				}else if(map[i][j]=='R') {
					arduino.add(new int[] {i,j});
				}
			}
		}
		
		String str = br.readLine().trim();
		boolean check = true;
		for (int i = 0; i < str.length(); i++) {
			int dir  = Integer.parseInt(str.charAt(i)+"");
			
			//종수 이동			
			check = jongsuMove(dir,i+1);
			if(!check) break;
			
			// 미친 아두이노 이동
			check = arduinoMove(arduino, i+1);
			if(!check) break;
			
			// 2개 이상 체크
			bomb(arduino);
		}
		if(check) {
			for (int i = 0; i < R; i++) {				
				for (int j = 0; j < C; j++) {
					System.out.print(map[i][j]);
				}System.out.println();
			}
		}
	}

	private static void bomb(ArrayList<int[]> arduino) {
		
		int[][] dbcheck = new int[R][C];
		for (int i = 0; i < arduino.size(); i++) {
			dbcheck[arduino.get(i)[0]][arduino.get(i)[1]]++;
		}

		for (int i = arduino.size()-1; i >= 0; i--) {
			if(dbcheck[arduino.get(i)[0]][arduino.get(i)[1]]>1) {
				map[arduino.get(i)[0]][arduino.get(i)[1]]='.';
				arduino.remove(i);
			}else {
				// 순차적이 아닌 한번에 이동하는 것이기 떄문에 실제 위치를 담은 list를 기준으로 R 생성
				map[arduino.get(i)[0]][arduino.get(i)[1]]='R';
			}
		}
	}

	private static boolean arduinoMove(ArrayList<int[]> arduino, int count) {
		int size = arduino.size();
		for (int i = 0; i < size; i++) {
			int min = Integer.MAX_VALUE;
			int dir = 0;
			
			for (int d = 1; d <= 9; d++) {
				if(d==5) continue;
				int tr = arduino.get(i)[0] + dr[d];
				int tc = arduino.get(i)[1] + dc[d];
				if(cango(tr,tc)) {
					int distance = Math.abs(sr-tr)+Math.abs(sc-tc);
					
					if(min>distance) {
						min = distance;
						dir = d;
					}					
				}
			}	
			// 가장 거리작은 곳으로 이동
			int nr = arduino.get(i)[0] + dr[dir];
			int nc = arduino.get(i)[1] + dc[dir];
			
			if(cango(nr,nc)) {
				if(map[nr][nc]=='I') {
					System.out.println("kraj "+count);
					return false;
				}
				map[arduino.get(i)[0]][arduino.get(i)[1]] = '.';
				arduino.set(i, new int[] {nr,nc});
			}
		}
		
		return true;
	}

	private static boolean jongsuMove(int dir, int count) {
		int nr = sr + dr[dir];
		int nc = sc + dc[dir];
		
		if(cango(nr,nc)) {
			if(map[nr][nc]=='R') {
				System.out.println("kraj "+count);
				return false;
			}
			// 제자리 가만히 일경우를 위해 순서 고정
			map[sr][sc] = '.';
			map[nr][nc] = 'I';
			sr = nr;
			sc = nc;
		}
		
		return true;
	}

	private static boolean cango(int r, int c) {
		return r>=0 && c>=0 && r<R && c<C;
	}

}
