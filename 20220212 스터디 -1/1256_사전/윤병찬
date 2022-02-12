package boj;

import java.util.Scanner;

public class Boj_1256 {
    static int n, m, k;
    static int cnt;
    static boolean fin;

    //ncm 계산
    public static int ncm(int a, int b){
        long ret = 1;

        if(b > a - b) b = a - b;
        for(int i = 1; i <= b; i++){
            ret *= a - i + 1;
            ret /= i;

            if(ret > k) {
                ret = 1000000000;
                break;
            }
        }

        return (int)ret;
    }

    public static void recur(String str, int a, int b){
        //이미 끝나서 출력했다면 그냥 더 진행 안하고 모든 함수 종료
        if(fin) return;

        //만약 이대로 계속 진행해도 k번째를 못구한다면 그냥 그 개수만큼 cnt에 더해주고 건너뛰기
        if(cnt + ncm(a + b, b) < k){
            cnt += ncm(a + b, b);
            return;
        }

        //끝까지 도착했다면 출력하고 끝났다는걸 fin에 표시
        if(a == 0 && b == 0){
            System.out.print(str);
            fin = true;
            return;
        }

        //이번에 'a' 붙여보고, 'z' 붙여보고
        if(a > 0)  recur(str + "a", a - 1, b);
        if(b > 0) recur(str + "z", a, b - 1);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        recur("", n, m);

        if(!fin) System.out.print(-1);
    }
}
