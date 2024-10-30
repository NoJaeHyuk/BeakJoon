class Solution {
    public int solution(String s) {
        int answer = 0;
        char x = s.charAt(0);
        int xCount = 1;
        int xNotCount = 0;
        
        int balance = 0;
        
        for(char c : s.toCharArray()) {
            if(balance == 0){
                x = c;
            }
            
            if(x == c){
                balance++;
            }else {
                balance--;
            }
            
            if(balance == 0) {
                answer++;
            }
        }
        
        if(balance != 0){
            answer++;
        }
        
        return answer;
    }
}