import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_1735_분수합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(stz.nextToken());
        int b = Integer.parseInt(stz.nextToken());
        stz = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(stz.nextToken());
        int d = Integer.parseInt(stz.nextToken());

        int x = a * d + c * b;
        int y = b * d;

        minimize(x,y);
    }

    private static void minimize(int x, int y) {
        int a = x, b = y;
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        x /= a;
        y /= a;
        System.out.println(x+" "+y);
    }
}
