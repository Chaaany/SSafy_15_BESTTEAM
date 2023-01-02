import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_S1_2002_추월 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> cars = new HashMap<>();
        for(int i = 0; i < N; i++) {
            cars.put(br.readLine(), i);
        }
        int[] rank = new int[N];
        for (int i = 0; i < N; i++) {
            String out = br.readLine();
            rank[i] = cars.get(out);
        }
        int cnt = 0;
        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                if(rank[i] > rank[j]) {
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
