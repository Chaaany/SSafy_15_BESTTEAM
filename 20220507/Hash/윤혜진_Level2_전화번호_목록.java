import java.util.*;

class Solution {
	public boolean solution(String[] phone_book) {
		boolean answer = true;

		HashMap<String, Integer> hash = new HashMap<>();

		for (String phone : phone_book) {
			hash.put(phone, 0);
		}

		loop: for (String phone : phone_book) {
			for (int i = 0; i < phone.length(); i++) {
				String sub = phone.substring(0, i);

				if (hash.containsKey(sub)) {
					answer = false;
					break loop;
				}

			}
		}

		return answer;
	}
}
