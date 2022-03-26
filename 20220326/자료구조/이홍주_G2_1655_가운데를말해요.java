import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class 이홍주_G2_1655_가운데를말해요 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pqmax = new PriorityQueue<>(Collections.reverseOrder()); // 앞쪽
		PriorityQueue<Integer> pqmin = new PriorityQueue<>(); // 뒤쪽 
		pqmax.add(Integer.MIN_VALUE);
		pqmin.add(Integer.MAX_VALUE);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(pqmax.size()<=pqmin.size()) {
				if(pqmin.peek()<x) {
					pqmax.add(pqmin.poll());
					pqmin.add(x);
					sb.append(pqmax.peek()+"\n");
					continue;
				}				
				pqmax.add(x);
				sb.append(pqmax.peek()+"\n");
			}else {
				if(pqmax.peek()>x) {
					pqmin.add(pqmax.poll());
					pqmax.add(x);
					sb.append(pqmax.peek()+"\n");
					continue;
				}					
				pqmin.add(x);
				sb.append(pqmax.peek()+"\n");
			}
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}
