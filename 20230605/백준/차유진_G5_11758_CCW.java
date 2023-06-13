import java.util.Scanner;

public class Main_G5_11758_CCW {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ax = sc.nextInt();
        int ay = sc.nextInt();
        int bx = sc.nextInt();
        int by = sc.nextInt();
        int cx = sc.nextInt();
        int cy = sc.nextInt();
        int ans = (bx-ax)*(cy-ay)-(cx-ax)*(by-ay);
        if(ans>0) ans = 1;
        else if(ans<0) ans = -1;
        System.out.println(ans);
    }
}
