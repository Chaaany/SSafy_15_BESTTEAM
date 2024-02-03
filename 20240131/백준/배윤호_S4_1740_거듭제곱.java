import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long N = Long.parseLong(br.readLine());

        Long ans = 0L;
        while (N > 0L) {
            Long temp = 0L;
            Long num = 1L;
            while (N >= num * 2L) {
                num *= 2L;
                temp++;
            }
            N -= num;
            ans += Pow(temp);
        }
        System.out.println(ans);
    }

    private static Long Pow(Long tempCnt) {
        Long result = 1L;
        for (int i=0;i<tempCnt;i++){
            result *= 3;
        }
        return result;
    }
}

