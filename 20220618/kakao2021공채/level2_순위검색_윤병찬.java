class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        String parsedQ[][] = new String[query.length][8];
        String parsedI[][] = new String[info.length][5];
        
        
        for(int i = 0; i < query.length; i++){
            parsedQ[i] = query[i].split(" ");
            // 0: 개발언어, 2 : 직군, 4: 경력, 6: 소울푸드, 7 : 점수
        }
        
        
        for(int i = 0; i < info.length; i++){
            parsedI[i] = info[i].split(" ");
            
            
            for(int j = 0; j < query.length; j++){

                if(!(parsedI[i][0].equals(parsedQ[j][0]) || parsedQ[j][0].equals("-"))) continue; 
                if(!(parsedI[i][1].equals(parsedQ[j][2]) || parsedQ[j][2].equals("-"))) continue;
                if(!(parsedI[i][2].equals(parsedQ[j][4]) || parsedQ[j][4].equals("-"))) continue; 
                if(!(parsedI[i][3].equals(parsedQ[j][6]) || parsedQ[j][6].equals("-"))) continue; 
                if(!(Integer.parseInt(parsedI[i][4]) >= Integer.parseInt(parsedQ[j][7]))) continue;
                answer[j]++;   
            }
        }
        

        
        
        
        
        return answer;
    }
}
