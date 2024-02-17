import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        int year = 2019;
        int month = 1;
        int date = 4; // 금요일 시작
        int[] dates = new int[13];
        dates[1] = 31;
        dates[2] = 28;
        dates[3] = 31;
        dates[4] = 30;
        dates[5] = 31;
        dates[6] = 30;
        dates[7] = 31;
        dates[8] = 31;
        dates[9] = 30;
        dates[10] = 31;
        dates[11] = 30;
        dates[12] = 31;
        while (true) {
            if (year > N)
                break;

            if (year % 400 == 0) {
                dates[2] = 29;
            } else if (year % 100 != 0 && year % 4 == 0) {
                dates[2] = 29;
            } else {
                dates[2] = 28;
            }

            while (true) {
                if (month > 12)
                    break;
                if (date == 13)
                    ans++;
                date += 7;
                if (date > dates[month]) {
                    date = date - dates[month];
                    month++;
                }
            }
            year++;
            month = 1;
        }
        System.out.println(ans);

    }

}
