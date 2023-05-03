import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    	for(int i=0; i<N; i++){
    	    StringTokenizer st = new StringTokenizer(br.readLine());
    	    for(int j=0; j<N; j++){
    	        pq.add(Integer.parseInt(st.nextToken()));
    	    }
    	}
    	while(N>1){
    	    pq.poll();
    	    N--;
    	}
    	System.out.println(pq.poll());
	}
}
