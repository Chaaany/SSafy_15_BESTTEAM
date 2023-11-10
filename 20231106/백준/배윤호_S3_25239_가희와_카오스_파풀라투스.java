import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String time = br.readLine();
        int h = Integer.parseInt(time.substring(0, 2));
        int m = Integer.parseInt(time.substring(3, 5));
        int minutes = h * 60 + m;
        boolean[] v = new boolean[6];
        int[] per = new int[6];
        int ans = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            per[i] = Integer.parseInt(st.nextToken());
        }
        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            double s = Double.parseDouble(st.nextToken());
            String T = st.nextToken();
            if (T.equals("^")) {
                if (minutes > 0 && minutes < 120) {
                    v[0] = true;
                } else if (minutes > 120 && minutes < 240) {
                    v[1] = true;
                } else if (minutes > 240 && minutes < 360) {
                    v[2] = true;
                } else if (minutes > 360 && minutes < 480) {
                    v[3] = true;
                } else if (minutes > 480 && minutes < 600) {
                    v[4] = true;
                } else if (minutes > 600 && minutes < 720) {
                    v[5] = true;
                }
            }
            else if (T.equals("10MIN"))
                minutes += 10;
            else if (T.equals("30MIN"))
                minutes += 30;
            else if (T.equals("50MIN"))
                minutes += 50;
            else if (T.equals("2HOUR"))
                minutes += 120;
            else if (T.equals("4HOUR"))
                minutes += 240;
            else if (T.equals("9HOUR"))
                minutes += 540;

            if (minutes >= 720)
                minutes -= 720;
        }
        for (int i = 0; i < 6; i++) {
            if (!v[i]) {
                ans += per[i];
            }
        }
        if (ans > 100) {
            ans = 100;
        }
        System.out.println(ans);
    }

}
