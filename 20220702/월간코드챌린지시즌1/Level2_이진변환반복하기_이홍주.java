class Solution {
    public int[] solution(String s) {
        
        int zero_sum = 0;
        int total = 0;
        String tmp_s = s;
        while(true){
           
           if(tmp_s.length()==1) break;
           int tmp=0;
            
           for(int i=0;i<tmp_s.length();i++){
                if(tmp_s.charAt(i)=='0') {
                    zero_sum++;
                    tmp++;
                }
            }  
            StringBuilder sb = new StringBuilder();
             int size = tmp_s.length()-tmp;
            int tsize = size;
             while(true){
                 if(tsize==0) break;
                 sb.append(tsize%2);
                 tsize/=2;
             }
            tmp_s = sb.toString();
             total++;
        }
        int[] answer = {total,zero_sum};
        return answer;
    }
}
