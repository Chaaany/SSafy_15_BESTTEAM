import java.io.*;
import java.util.*;

public class BJ_20440_니가싫어 {

	static class Time implements Comparable<Time>{
		int type;
		long time;
		
		public Time(int type, long time) {
			this.type = type;
			this.time = time;
		}

		@Override
		public int compareTo(Time t) {
			// 퇴장 먼저
			if(this.time==t.time) return t.type - this.type;
			else return (int) (this.time-t.time);
		}	
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Time> pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			// 0이 입장 1이 퇴장
			pq.add(new Time(0, Long.parseLong(st.nextToken())));
			pq.add(new Time(1, Long.parseLong(st.nextToken())));
		}
		
		int answer = 0;
		int count = 0;
		long start = 0;
		long end = 0;
		long before = -1;
		boolean check = false;
		
		while(!pq.isEmpty()) {
			Time now = pq.poll();
			
			
			if(now.type==0) {
				count++;
				if(answer<count) {
					start = now.time;
					answer = count;
					check = true;
				}else if(answer == count && before != now.time) {
					// 시간이 이어지지 않을 경우 end 갱신 하면 안됨
					check = false;
				}else if(answer == count && before == now.time) {
					// 시간이 이어질 경우 end 갱신 가능
					check = true;				
				}else check = false;
				
			}else {
				if(check && answer == count) {
					end = now.time;
				}
				count--;				
			}
			
			before = now.time;
		}
		
		System.out.println(answer);
		System.out.println(start+" "+end);
	}

}
