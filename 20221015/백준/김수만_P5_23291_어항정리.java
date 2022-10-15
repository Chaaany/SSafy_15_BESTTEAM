import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		st = new StringTokenizer(br.readLine());
		int max = 0;
		int min = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
		}
		
		if(max - min <= K) {
			System.out.println(0);
			return;
		}
		
		int ans = 0;
		
		while(max - min > K) {
			// step1 - 물고기 수가 가장 적은 어항에 물고기 한 마리 넣기
			for(int i=0; i<N; i++) {
				if(arr[i] == min) arr[i]++;
			}
			
			int[][] fishbowl = null;
			int over = 0, next = 1; // 겹치는 어항 개수, 다음 겹쳐질 어항 개수
			int flag = 0;
			while(true) {
				int tmp[][];
				if(over == 0) {
					tmp = new int[2][N-1];
					tmp[0][0] = arr[0];
					for(int i=0; i<N-1; i++) {
						tmp[1][i] = arr[i+1];
					}
					over = 1;
					next = 2;
					fishbowl = tmp;
				}
				else {
					if(fishbowl[0].length - over < next) break; // 공중부양 끝
					int[][] narr = new int[next][over];
					for(int i=0; i<next; i++) {
						for(int j=0; j<over; j++) {
							narr[i][j] = fishbowl[i][j];
						}
					}
					
					narr = rotate(narr);
					int[] bottom = Arrays.copyOf(fishbowl[fishbowl.length-1], fishbowl[0].length);
					fishbowl = new int[over+1][fishbowl[0].length-over];
					for(int i=0; i<fishbowl.length; i++) {
						for(int j=0; j<fishbowl[i].length; j++) {
							if(i == fishbowl.length-1)
								fishbowl[i][j] = bottom[j+over];
							else if(j >= next) 
								fishbowl[i][j] = 0;
							else 
								fishbowl[i][j] = narr[i][j];
						}
					}
					
					over = next;
					if(flag % 2 == 0) next++;
				}
				
				flag++;
			}
			
			// 물고기 수 조절하기
			adjust(fishbowl);	
			
			// 바닥에 일렬로 놓기
			int a = 0;
			for(int j=0; j<fishbowl[0].length; j++) {
				for(int i=fishbowl.length-1; i>=0; i--) {
					if(fishbowl[i][j] == 0) continue;
					arr[a++] = fishbowl[i][j];
				}
			}
			
			// 공중부양 작업 2
			fishbowl = new int[1][N];
			fishbowl[0] = Arrays.copyOf(arr, N);
			for(int i=0; i<2; i++) {
				int tmp[][] = new int[fishbowl.length][fishbowl[0].length/2];
				int tmp2[][] = new int[fishbowl.length][fishbowl[0].length/2];
				for(int x=0; x<tmp.length; x++) {
					for(int y=0; y<tmp[x].length; y++) {
						tmp[x][y] = fishbowl[x][y];
						tmp2[x][y] = fishbowl[x][y+fishbowl[0].length/2];
					}
				}
				tmp = rotate2(tmp);
				fishbowl = new int[fishbowl.length*2][fishbowl[0].length/2];
				for(int x=0; x<fishbowl.length; x++) {
					for(int y=0; y<fishbowl[x].length; y++) {
						if(x < fishbowl.length/2)
							fishbowl[x][y] = tmp[x][y];
						else
							fishbowl[x][y] = tmp2[x-fishbowl.length/2][y];
					}
				}
			}
			
			// 물고기 수 조절하기 2
			adjust(fishbowl);
			
			// 바닥에 일렬로 놓기 2
			a = 0;
			max = 0;
			min = Integer.MAX_VALUE;
			for(int j=0; j<fishbowl[0].length; j++) {
				for(int i=fishbowl.length-1; i>=0; i--) {
					if(fishbowl[i][j] == 0) continue;
					max = Math.max(max, fishbowl[i][j]);
					min = Math.min(min, fishbowl[i][j]);
					arr[a++] = fishbowl[i][j];
				}
			}
			
			ans++;
		}
		
		System.out.println(ans);
	}

	// 어항 시계방향으로 90도 회전하기
	static int[][] rotate(int[][] arr) {
		int narr[][] = new int[arr[0].length][arr.length];
		int a = 0, b = 0;
		for(int j=0; j<arr[0].length; j++) {
			for(int i=arr.length-1; i>=0; i--) {
				narr[a][b++] = arr[i][j];
			}
			a++;
			b = 0;
		}
		
		return narr;
	}
	
	// 어항 시계방향으로 180도 회전하기
	static int[][] rotate2(int[][] arr) {
		int narr[][] = new int[arr.length][arr[0].length];
		int a = 0, b = 0;
		for(int i=arr.length-1; i>=0; i--) {
			for(int j=arr[0].length-1; j>=0; j--) {
				narr[a][b++] = arr[i][j];
			}
			a++;
			b = 0;
		}
		return narr;
	}
	
	static void adjust(int[][] fishbowl) {
		boolean v[][] = new boolean[fishbowl.length][fishbowl[0].length];
		int[][] diff = new int[fishbowl.length][fishbowl[0].length];
		for(int i=0; i<fishbowl.length; i++) {
			for(int j=0; j<fishbowl[0].length; j++) {
				if(v[i][j] || fishbowl[i][j] == 0) continue;
				v[i][j] = true;
				for(int d=0; d<4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];
					if(nx < 0 || ny < 0 || nx >= fishbowl.length ||
							ny >= fishbowl[0].length || fishbowl[nx][ny] == 0) continue;
					v[nx][ny] = true;
					int val = Math.abs(fishbowl[i][j] - fishbowl[nx][ny])/5;
					if(fishbowl[i][j] < fishbowl[nx][ny]) {
						diff[nx][ny] -= val;
						diff[i][j] += val;
					}
					else {
						diff[nx][ny] += val;
						diff[i][j] -= val;
					}
				}
			}
		}
		
		for(int i=0; i<fishbowl.length; i++) {
			for(int j=0; j<fishbowl[0].length; j++) {
				fishbowl[i][j] += diff[i][j];
			}
		}
	}
	
}
