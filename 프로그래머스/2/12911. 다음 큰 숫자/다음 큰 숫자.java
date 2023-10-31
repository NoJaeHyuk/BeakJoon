class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String num2Str = Integer.toString(n, 2);
        int c_count = countChar(num2Str,'1');
        
        while(true){
            n = n + 1;
            
            String com2Str = Integer.toString(n, 2);
            
            if(countChar(com2Str,'1') == c_count){
                answer = n;
                break;
            }
        }
        
        return answer;
    }
    
    public static int countChar(String str, char ch) {
        int count = 0;
 
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
 
        return count;
    }
}