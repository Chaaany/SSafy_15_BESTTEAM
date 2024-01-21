class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        combi(0,0,0,numbers, target);
        return answer;
    }
    public void combi(int cnt, int start, int result, int[] numbers, int target){
        if(cnt==numbers.length){
            if(result==target){
                answer++;
            }
            return;
        }
        for(int i = start; i< numbers.length; i++){
            result += numbers[i];
            combi(cnt+1,i+1,result,numbers,target);
            result -= numbers[i];
            result -= numbers[i];
            combi(cnt+1,i+1,result,numbers,target);
            result += numbers[i];
        }
    }
}
