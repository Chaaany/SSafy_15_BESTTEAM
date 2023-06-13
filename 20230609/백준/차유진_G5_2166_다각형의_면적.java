import java.io.*;
import java.text.NumberFormat;

public class Main_G5_2166_다각형의면적 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] points = new long[N][2];
        String[] input = new String[2];
        for(int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            points[i][0] = Long.parseLong(input[0]) + 100000;
            points[i][1] = Long.parseLong(input[1]) + 100000;
        }
        long area = 0;
        long x = points[0][0];
        long y = points[0][1];
        for(int i = 1; i < N-1; i++) {
            area += (points[i][0]*points[i+1][1]+points[i+1][0]*y+x*points[i][1]-points[i+1][0]*points[i][1]-x*points[i+1][1]-points[i][0]*y);
        }
        area = Math.abs(area);
        double ans = (double)area/2;
        NumberFormat f = NumberFormat.getInstance();
        f.setGroupingUsed(false);
        f.setMinimumFractionDigits(1);
        System.out.println(f.format(ans));
    }
}
