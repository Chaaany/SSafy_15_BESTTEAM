import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//강의실 배정
public class Main {

	static class Lecture implements Comparable<Lecture>{
		int start, end;
		
		Lecture(int start, int end){
			this.start = start;
			this.end = end;
		}
		
		public int compareTo(Lecture o) {
			return Integer.compare(this.start, o.start);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Lecture> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(list);
		
		//우선순위큐 - minHeap
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		//각 강의장의 끝나는 시간을 pq에 저장 -> 들어갈 수 있으면 끝나는 시간 갱신 / 들어갈 수 없으면 pq에 새로 넣기
		//-> pq의 크기가 필요한 강의장의 개수가 된다.
		for(Lecture lecture : list) {
			if(pq.size() == 0) {
				pq.add(lecture.end);
				continue;
			}
			int min = pq.peek();
			if(min > lecture.start) {
				pq.add(lecture.end);
			}
			else {
				pq.poll();
				pq.add(lecture.end);
			}
		}
		
		System.out.println(pq.size());
	}

}
