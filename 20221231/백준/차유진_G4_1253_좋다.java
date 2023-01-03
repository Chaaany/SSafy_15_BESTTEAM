import java.util.*;

public class Main_G4_1253_좋다 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        int cnt = 0;
        Arrays.sort(nums);
        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N-1;
            while(left < right) {
                if(left == i) {
                    left++;
                } else if(right == i) {
                    right--;
                } else {
                    if(nums[i] == nums[left] + nums[right]) {
                        cnt++;
                        break;
                    } else if(nums[i] > nums[left] + nums[right]) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        System.out.println(cnt);

    }
}
