class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        String[] lang = new String[info.length];
        String[] pos = new String[info.length];
        String[] career = new String[info.length];
        String[] menu = new String[info.length];
        String[] score = new String[info.length];
        
        for(int i=0; i<info.length; i++){
            String[] str = info[i].split(" ");
            lang[i] = str[0];
            pos[i] = str[1];
            career[i] = str[2];
            menu[i] = str[3];
            score[i] = str[4];
        }
        
        for(int i=0; i<query.length; i++){
            String[] str = query[i].split(" ");
            int res = 0;
            for(int j=0; j<info.length; j++){
                if(!str[0].equals("-") && !str[0].equals(lang[j])) continue;
                if(!str[2].equals("-") && !str[2].equals(pos[j])) continue;
                if(!str[4].equals("-") && !str[4].equals(career[j])) continue;
                if(!str[6].equals("-") && !str[6].equals(menu[j])) continue;
                int sco1 = Integer.parseInt(str[7]), sco2 = Integer.parseInt(score[j]);
                if(sco1 > sco2) continue;
                
                res++;
            }
            answer[i] = res;
        }
        
        return answer;
    }
}
