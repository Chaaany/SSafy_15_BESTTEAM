import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] jagu = new int[N];
        int[] arr = new int[N];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            jagu[i] = Integer.parseInt(st1.nextToken());
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        Queue<Integer> que = new LinkedList<>();
        for (int i = N - 1; i >= 0; i--) {
            if (jagu[i] == 0) {
                que.add(arr[i]);
            }
        }
        int M = Integer.parseInt(br.readLine());
        st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            que.add(Integer.parseInt(st1.nextToken()));
            sb.append(que.poll() + " ");
        }
        System.out.println(sb);

    }

}
