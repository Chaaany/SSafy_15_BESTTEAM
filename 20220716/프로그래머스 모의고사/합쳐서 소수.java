class Solution {
    static int tempCnt, arr[];
    public int solution(int[] nums) {
        int answer = -1;
        tempCnt = 0;
        arr = new int[3];
        nCr(0, 0, 3, nums);


        return tempCnt;
    }

    public static void nCr(int cnt, int start, int N, int[] nums){
        if (cnt == N){
            if(isPrime()){
                System.out.println("asdfsd");
                tempCnt = tempCnt + 1;
            }

            return;
        }

        for(int i = start; i < nums.length; i++){
            arr[cnt] = nums[i];
            nCr(cnt+1, i+1, N, nums);
        }
    }

    public static boolean isPrime(){
        int sum = 0;
        int cnt = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        if(sum == 1){ // 의미 없음
            return false;
        }

        for(int i = 2; i * i <= sum; i++){
            if(sum % i == 0){
                return false;                
            }
        }
        System.out.println(sum);
        return true;
    }
}
