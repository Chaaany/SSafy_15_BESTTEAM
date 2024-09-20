import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        List<Integer> primes = new ArrayList<Integer>();

        for(int i = 2; i <= N; i++ )
            if(isPrime(i)) primes.add(i);

        for (int n : primes) {
            int m = 1;
            while (n * m <= N) {
                if (!set.contains(n * m)) set.add(n * m);
                if (set.size() == K) {
                    System.out.println(n * m);
                    return;
                }
                m++;
            }
        }
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }
}
