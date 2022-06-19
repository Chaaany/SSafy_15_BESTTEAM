class Solution {
     static int answer = Integer.MAX_VALUE;
    public static int solution(String begin, String target, String[] words) {

        int count = 0;
        boolean[] v = new boolean[words.length];
        find(begin, target,words,v,count);
        if(answer==Integer.MAX_VALUE) {
            answer = 0;
        }
        return answer;
    }
      public static void find(String begin, String target, String[] words, boolean[] v,int count) {
        if(begin.equals(target)){
            answer = Math.min(answer, count);
            return;
        }
        for (int i = 0; i < words.length; i++) {
            int cnt = 0;
            if(v[i]) continue;
            for (int j = 0; j < words[i].length(); j++) {
                if(begin.charAt(j)==words[i].charAt(j)){
                    cnt++;
                }
            }
            if(cnt==begin.length()-1) {
                v[i] = true;                
                find(words[i],target,words,v,count+1);
                v[i] = false;
            }
        }
    }

}
