//
//class Solution {
//    final int INF = 9999999;
//    public int solution(int n, int[][] results) {
//        int answer = 0;
//        int[][] map = new int[n+1][n+1];
//        int[][] map2 = new int[n+1][n+1];
//        for(int i = 0; i<results.length; i++){
//            map[results[i][0]][results[i][1]] = 1;
//            map2[results[i][1]][results[i][0]] = 1;
//        }
//        
//         for(int i=1; i<=n; i++){
//            for(int j =1; j<=n; j++){
//                if(i==j) continue;
//                if(map[i][j]==0) map[i][j] = INF;
//                if(map2[i][j]==0) map2[i][j] = INF;
//            }
//         }
//        for(int k=1; k<=n;k++){
//            for(int i=1; i<=n; i++){
//                if(i==k) continue;
//                for(int j =1; j<=n; j++){
//                    if(k==j || i==j) continue;
//                    if(map[i][j]>map[i][k]+map[k][j]){
//                        map[i][j]=map[i][k]+map[k][j];
//                    }
//                     if(map2[i][j]>map2[i][k]+map2[k][j]){
//                        map2[i][j]=map2[i][k]+map2[k][j];
//                    }
//                }
//            }
//        }
//       
//        go: for(int i = 1; i<=n ; i++){
//            for(int j = 1; j<=n; j++){
//                 if(map[i][j]==INF && map2[i][j]==INF) continue go;
//            }     
//            answer++;
//        }
//        return answer;
//    }
//}