class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        
        
        int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
        
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                boolean isTrue = true;
                if(board[i][j] != 1){
                    for(int k = 0; k < dr.length; k++){
                        int cx = i + dr[k]; 
                        int cy = j + dc[k];

                        if(cx >= 0 && cx < board.length && cy >= 0 && cy < board.length
                           && board[cx][cy] == 1){
                            isTrue = false;
                            break;
                        }
                    } 
                    
                    if(isTrue){
                        answer++;
                    }
                }
            }
        }
        
        
        return answer;
    }
}