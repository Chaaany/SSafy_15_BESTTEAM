import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_RankingWaitingQueue {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<Room> rooms = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		int l = Integer.parseInt(st.nextToken());
		String n = st.nextToken();
		rooms.add(new Room(l, n));
		for (int i = 1; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken());
			n = st.nextToken();
			int size = rooms.size();
			boolean check = true;
			for (int j = 0; j < size; j++) {
				Room temp = rooms.get(j);
				if (temp.level - 10 > l || temp.level + 10 < l) {
					continue;
				}
				if (temp.person.size() == m) {
					continue;
				}
				temp.person.add(new User(l, n));
				check = false;
				break;
			}
			if (check) {
				rooms.add(new Room(l, n));
			}
		}
		for (Room r : rooms) {
			if (r.person.size() == m) {
				sb.append("Started!").append("\n");
			} else {
				sb.append("Waiting!").append("\n");
			}
			while (!r.person.isEmpty()) {
				User u = r.person.poll();
				sb.append(u.lev + " " + u.name).append("\n");
			}
		}
		System.out.println(sb);
	}

	public static class Room {
		int level;
		PriorityQueue<User> person = new PriorityQueue<>();

		Room(int level, String name) {
			this.level = level;
			this.person.add(new User(level, name));
		}
	}

	public static class User implements Comparable<User> {
		int lev;
		String name;

		User(int lev, String name) {
			this.lev = lev;
			this.name = name;
		}

		@Override
		public int compareTo(User u) {
			return this.name.compareTo(u.name);
		}
	}

}
