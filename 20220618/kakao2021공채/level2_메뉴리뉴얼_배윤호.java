import java.util.*;
import java.io.*;

class Solution {
    static Set<Character> menuset;
    static List<String> answerlist;
    static int R = 0;
    static char[] chars;
    static Character[] menu;
    static List<Character>[] list;
    static int max = 2;
    static int including = 0;
    static String a = "";
    
    	public static String[] solution(String[] orders, int[] course) {
		String[] answer = {};
		list = new LinkedList[orders.length];
		answerlist = new LinkedList<String>();
		menuset = new HashSet<Character>();

		int length[] = new int[21];
		for (int i = 0; i < orders.length; i++) {
			list[i] = new LinkedList<Character>();
		}
		for (int i = 0; i < orders.length; i++) {
			String s = orders[i];
			for (int j = 1; j <= s.length(); j++) {
				length[j]++;
			}
			for (int j = 0; j < s.length(); j++) {
				list[i].add(s.charAt(j));
				menuset.add(s.charAt(j));
			}
		}
		menu = menuset.toArray(new Character[0]);
		for (int i = 0; i < course.length; i++) {
			R = course[i];
			max = 2;
            a = "";
			if (length[R] < 2)
				continue;
			chars = new char[R];
			combi(0, 0);
			for (int j = 0; j < a.length(); j += R) {
				answerlist.add(a.substring(j, j + R));
			}
		}
		answerlist.sort(null);
		answer = new String[answerlist.size()];
		for (int i = 0; i < answerlist.size(); i++) {
			answer[i] = answerlist.get(i);
		}
		
		return answer;
	}

	private static void combi(int cnt, int start) {
		if (cnt == R) {
			including = 0;
			check(chars);
			return;
		}
		for (int i = start; i < menu.length; i++) {
			chars[cnt] = menu[i];
			combi(cnt + 1, i + 1);
		}

	}

	private static void check(char[] chars) {
		go: for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < chars.length; j++) {
				if (!list[i].contains(chars[j])) {
					continue go;
				}
			}
			including++;
		}
		// System.out.println(Arrays.toString(chars)+" "+including);

		if (including == max) {
			for (int j = 0; j < chars.length; j++) {
				a += chars[j];
			}

			return;
		} else if (including > max) {
			max = including;
			a = "";
			for (int j = 0; j < chars.length; j++) {
				a += chars[j];
			}
			return;
		}

	}

}
