import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        List<space> belt = new ArrayList<>();
        Queue<Integer> robot = new LinkedList<>();
        for (int i = 0; i < N * 2; i++) {
            int a = Integer.parseInt(st.nextToken());
            belt.add(new space(a, false));
        }
        int zero = 0;
        int turn = 0;
        while (true) {
            turn++;
            belt.add(0, belt.get(belt.size() - 1));
            belt.remove(belt.size() - 1);
            if (belt.get(N - 1).r == true) {
                belt.get(N - 1).r = false;
                robot.poll();
            }
            int size = robot.size();
            for (int i = 0; i < size; i++) {
                int temp = robot.poll() + 1;
                if (belt.get(temp + 1).r == false && belt.get(temp + 1).d > 0) {
                    if (temp + 1 < N - 1) {
                        belt.get(temp).r = false;
                        belt.get(temp + 1).r = true;
                        belt.get(temp + 1).d -= 1;
                        if (belt.get(temp + 1).d == 0) {
                            zero++;
                        }
                        robot.add(temp + 1);
                    } else {
                        belt.get(temp).r = false;
                        belt.get(temp + 1).d -= 1;
                        if (belt.get(temp + 1).d == 0) {
                            zero++;
                        }
                    }
                } else {
                    robot.add(temp);
                }
            }
            if (belt.get(0).d > 0) {
                belt.get(0).r = true;
                robot.add(0);
                belt.get(0).d -= 1;
                if (belt.get(0).d == 0) {
                    zero++;
                }
            }
            if (zero >= K) {
                break;
            }
        }
        System.out.println(turn);
    }

    public static class space {
        int d;
        boolean r;

        space(int d, boolean r) {
            this.d = d; // durability
            this.r = r; // robot
        }
    }

}
