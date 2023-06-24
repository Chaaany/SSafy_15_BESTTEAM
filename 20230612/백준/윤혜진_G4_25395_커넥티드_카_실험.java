import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, S;
	static Car[] cars;
	static boolean[] v;
	
	public static class Car implements Comparable<Car> {
		int idx;
		int position;
		int fuel;
		
		public Car(int idx, int position) {
			this.idx = idx;
			this.position = position;
		}
		
		public int compareTo(Car o) {
			return this.position - o.position;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		cars = new Car[N+1];
		cars[0] = new Car(0,-1);
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			cars[i] = new Car(i, Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			cars[i].fuel = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(cars);
		bfs();
		
		for (int i = 1; i <= N; i++) {
			if(v[i]) sb.append(i+" ");
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

	private static void bfs() {
		Queue<Car> q = new LinkedList<>();
		v = new boolean[N+1];
		q.add(cars[S]);
		v[S] = true;
		
		while(!q.isEmpty()) {
			Car cur = q.poll();
			
			for (int i = cur.idx-1; i > 0; i--) {
				Car next = cars[i];
				
				if(cur.fuel < cur.position-next.position) break;
				if(v[next.idx]) continue;
				
				q.add(next);
				v[next.idx] = true;
			}
			for (int i = cur.idx+1; i <= N; i++) {
				Car next = cars[i];
				
				if(cur.fuel < next.position-cur.position) break;
				if(v[next.idx]) continue;
				
				q.add(next);
				v[next.idx] = true;
			}
		}
		
	}

}
