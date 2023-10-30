class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        
        char[][] array = new char[my_string.length()/m][m];
        
        int j = 0;
        
        for(int i = 0; i < my_string.length()/m; i++){
            array[i] = my_string.substring(j, j+m).toCharArray();
            j += m;
        }
        
        for(int i = 0; i < my_string.length()/m; i++){
            answer += Character.toString(array[i][c-1]);
        }    
        
        
        return answer;
    }
}