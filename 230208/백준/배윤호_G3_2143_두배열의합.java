import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2143_TwoSumArrays {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		int[] b = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		int totalA = gauss(n);
		int totalB = gauss(m);
		long[] sumA = new long[totalA];
		long[] sumB = new long[totalB];
		int index = 0;
		for (int i = 0; i < n; i++) {
			long sum = 0;
			for (int j = i; j < n; j++) {
				sum += a[j];
				sumA[index++] = sum;
			}
		}
		index = 0;
		for (int i = 0; i < m; i++) {
			long sum = 0;
			for (int j = i; j < m; j++) {
				sum += b[j];
				sumB[index++] = sum;
			}
		}
		Arrays.sort(sumA);
		Arrays.sort(sumB);

		int left = 0;
		int right = totalB - 1;
		long count = 0;
		while (left < totalA && right >= 0) {
			long leftSum = sumA[left];
			long rightSum = sumB[right];
			if (leftSum + rightSum == T) {
				long leftCount = 0;
				while (left < totalA && sumA[left] == leftSum) {
					leftCount++;
					left++;
				}
				long rightCount = 0;
				while (right >= 0 && sumB[right] == rightSum) {
					rightCount++;
					right--;
				}
				count += leftCount * rightCount;
			}

			if (leftSum + rightSum < T)
				left++;
			if (leftSum + rightSum > T)
				right--;
		}
		System.out.println(count);

	}

	private static int gauss(int temp) {
		int total = 0;
		total = (1 + temp) * (temp / 2);
		if (temp % 2 != 0) {
			total += (1 + temp) / 2;
		}
		return total;
	}

}
