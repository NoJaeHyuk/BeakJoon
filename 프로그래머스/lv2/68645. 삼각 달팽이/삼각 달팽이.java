class Solution {
    static int[] dx = {1,0,-1};
    static int[] dy = {0,1,-1};
    public int[] solution(int n) {
        //등차수열 
        //n(n+1)/2
        int[] answer = new int[n*(n+1)/2];
        
        int[][] check = new int[n][n];
        
        int ix = -1;
        int iy = 0;
        int curData = 1;
        
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(i%3 == 0){
                    //세로 
                    ix += dx[0];
                    iy += dy[0];
                }

                if(i%3 == 1){
                    //가로
                    ix += dx[1];
                    iy += dy[1];
                }

                if(i%3 == 2){
                    //대각선
                    ix += dx[2];
                    iy += dy[2];
                }   
                
                check[ix][iy] = curData++;
            }
        }
        
        int k = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(check[i][j] == 0) 
                	break;
                answer[k++] = check[i][j];
            }
        }
        
        
        return answer;
    }
}