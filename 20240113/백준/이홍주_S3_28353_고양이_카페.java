import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        long[] arr = new long[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = 0;
        int max_idx = N-1;
        
        for(int i=0;i<N;i++){
            if(max_idx<=i) break;
            if(arr[i]+arr[max_idx]<=K){
                answer++;         
            }else{
                i--;      
            }
            max_idx--;
        }

        System.out.println(answer);
        
    }
}
