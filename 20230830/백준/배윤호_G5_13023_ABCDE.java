import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] friendList;
	static boolean[] v;
	static boolean check = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		friendList = new ArrayList[N + 1];
		v = new boolean[N + 1];
		for (int i = 0; i < N + 1; i++) {
			friendList[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friendList[a].add(b);
			friendList[b].add(a);
		}

		for (int i = 1; i < N + 1; i++) {
			find(i, 1);
		}
		if (check) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}

	}

	private static void find(int friendNum, int count) {
		if (check)
			return;
		if (count == 5) {
			check = true;
			return;
		}
		v[friendNum] = true;
		for (int i = 0; i < friendList[friendNum].size(); i++) {
			int nextFriend = friendList[friendNum].get(i);
			if (v[nextFriend]) {
				continue;
			}
			find(nextFriend, count + 1);
		}
		v[friendNum] = false;

	}

}
