import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] v = new boolean[100001];
        v[1] = true;
        for (int i = 2; i * i < 100001; i++) {
            if (!v[i]) {
                for (int j = i * i; j < 100001; j += i)
                    v[j] = true;
            }
        }

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            if (!v[N]) {
                sb.append(N + " " + 1).append("\n");
                continue;
            }
            Map<Integer, Integer> map = new TreeMap<>();
            int temp = 2;
            while (N != 1) {
                if (N % temp == 0) {
                    map.put(temp, map.getOrDefault(temp, 0) + 1);
                    N /= temp;
                } else {
                    temp++;
                }
            }
            for (Integer key : map.keySet()) {
                sb.append(key + " " + map.get(key)).append("\n");
            }
        }
        System.out.println(sb);
    }

}
