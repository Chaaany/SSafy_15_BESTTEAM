import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_19941_HamburgerDistribution {

	public static void main(String[] args) throws Exception 	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        int p = 0;
        boolean[] v = new boolean[s.length()];
        for(int i=0; i<s.length();i++) {
        	if(s.charAt(i)=='P') {
        		boolean eat = false;
        		int start = Math.max(0, i-K);
        		for (int j = start; j < i; j++) {
					if(s.charAt(j)=='H' && !v[j]) {							
						v[j] = true;
						eat = true;
						p++;
						break;
					}
				}
        		if(!eat) {
        			int end = Math.min(s.length(), i+1+K);
            		for (int j = i+1; j < end; j++) {
    					if(s.charAt(j)=='H' && !v[j]) {
    						v[j] = true;
    						eat = true;
    						p++;
    						break;
    					}
    				}
        		}
        	}
        }
        System.out.println(p);
 	}

}
