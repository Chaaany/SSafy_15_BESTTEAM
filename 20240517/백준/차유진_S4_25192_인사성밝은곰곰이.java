import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_S4_25192_인사성밝은곰곰이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        String s = br.readLine();
        Set<String> set = new HashSet<>();
        for(int i = 1; i < N; i++) {
            s = br.readLine();
            if(s.equals("ENTER"))
                set = new HashSet<>();
            else {
                if(!set.contains(s)) {
                    set.add(s);
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
