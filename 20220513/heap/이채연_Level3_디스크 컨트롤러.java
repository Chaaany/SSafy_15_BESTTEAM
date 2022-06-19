import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0, time=0;
        PriorityQueue<int[]> req=new PriorityQueue<>(new Comparator<int[]>(){  //요청시간 빠른순으로, 같을 때에는 소요시간 적은 순으로
            public int compare(int[] a, int[] b){
                if (a[0]==b[0]){
                    return Integer.compare(a[1], b[1]);
                }
                return Integer.compare(a[0], b[0]);
            }
        });    
        PriorityQueue<int[]> work=new PriorityQueue<>(new Comparator<int[]>(){  //소요시간 적은 순으로, 같을 때에는 요청시간 빠른 순으로
            public int compare(int[] a, int[] b){
                if (a[1]==b[1]){
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            }
        });    
        for (int i=0; i<jobs.length; i++){
            req.add(jobs[i]);       //job들을 다 넣어준 후 요청시간 빠른 순으로 뽑아올 수 있도록
        }
        while (!work.isEmpty() || !req.isEmpty()){
            if (work.isEmpty()){                //한참 있다가 작업이 요청될 때
                work.add(req.poll());
                time=work.peek()[0]; //시간은 그 요청시간으로 당겨준다
            }
            int[] job=work.poll();  //대기 job 중 소요시간이 짧은 애들 선택
            answer+=(time-job[0]+job[1]);
            time+=job[1]; 
            while (!req.isEmpty()){
                if (req.peek()[0]<=time){
                    work.add(req.poll());
                }
                else{
                    break;
                }
            }
        }
        return answer/jobs.length;
    }
}
