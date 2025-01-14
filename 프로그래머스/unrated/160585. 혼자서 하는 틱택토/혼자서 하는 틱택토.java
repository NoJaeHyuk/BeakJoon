class Solution {
    public int solution(String[] board) {
            int answer = 1;

            char[][] arr = new char[board.length][];
            int o_cnt = 0;
            int x_cnt = 0;

            for(int i = 0; i < board.length; i++){
                arr[i] = board[i].toCharArray();
                for(int j = 0; j < 3; j++){
                    if (arr[i][j] == 'O')
                        o_cnt++;
                    if (arr[i][j] == 'X')
                        x_cnt++;
                }
            }

            //X가 O보다 많은 경우
            if(x_cnt > o_cnt){
                return 0;
            }

            if(x_cnt == 0 && o_cnt == 0){
                return 1;
            }

            //'O'가 'X'보다 2개이상 많으면 규칙 위반
            if (o_cnt > x_cnt + 1) {
                return 0;
            }

            if (check(arr, 'O')) {
                if(o_cnt == x_cnt){
                    return 0;
                }
            }

            if (check(arr, 'X')) {
                if(o_cnt == x_cnt + 1){
                    return 0;   
                }
            }

            return answer;
        }

        private static boolean check(char[][] arr, char ch) {
            //가로 검사
            for (int i = 0; i < 3; i++) {
                if (arr[i][0] == ch
                    && arr[i][1] == ch
                    && arr[i][2] == ch) {
                    return true;
                }
            }

            //세로 검사
            for (int i = 0; i < 3; i++) {
                if (arr[0][i] == ch
                    && arr[1][i] == ch
                    && arr[2][i] == ch) {
                    return true;
                }
            }

            //대각선 검사
            if (arr[0][0] == ch
                && arr[1][1] == ch
                && arr[2][2] == ch) {
                return true;
            }

            if (arr[0][2] == ch
                && arr[1][1] == ch
                && arr[2][0] == ch) {
                return true;
            }

            return false;
        }
}