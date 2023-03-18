import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static boolean[] v;
	static int[] map, path;
	static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		v = new boolean[200001];
		map = new int[200001];
		path = new int[200001];
		
		bfs();
		sb.append(map[K]+"\n");

		Stack<Integer> stack = new Stack<>();
		int cur = K;
		while(true) {
			stack.push(cur);
			if(cur==N) break;
			cur = path[cur]; // 이전경로 저장되어 있으므로 거꾸로 찾아감
		}
		
		int size = stack.size();
		for(int i = 0; i < size; i++) {
			sb.append(stack.pop()+" ");
		}
		
		System.out.println(sb);
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		v[N] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(cur == K) break;
			
			if(cur-1<200001 && cur-1>=0 && !v[cur-1]) {
				q.add(cur-1);
				v[cur-1] = true;
				map[cur-1] = map[cur]+1;
				path[cur-1] = cur; // 어디에서 왔는지 이전경로 저장
			}
			if(cur+1<200001 && cur+1>=0 && !v[cur+1]) {
				q.add(cur+1);
				v[cur+1] = true;
				map[cur+1] = map[cur]+1;
				path[cur+1] = cur;
			}
			if(cur*2<200001 && cur*2>=0 && !v[cur*2]) {
				q.add(cur*2);
				v[cur*2] = true;
				map[cur*2] = map[cur]+1;
				path[cur*2] = cur;
			}
		}
	}

}
