import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class WhatDoesTheFoxSay {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            List<String> cries = new ArrayList<String>(Arrays.asList(br.readLine().split(" ")));
            while (true) {
                String s = br.readLine();
                if (s.equals("what does the fox say?")) {
                    break;
                }
                StringTokenizer st = new StringTokenizer(s);
                String animal = st.nextToken();
                String goes = st.nextToken();
                String cry = st.nextToken();
                cries.removeAll(Arrays.asList(cry));
            }
            for (String cry : cries) {
                sb.append(cry + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
