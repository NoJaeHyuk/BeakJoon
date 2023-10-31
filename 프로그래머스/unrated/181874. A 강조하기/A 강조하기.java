class Solution {
    public String solution(String myString) {
        String answer = "";
        
        myString = myString.toLowerCase();
        
        for(char c : myString.toCharArray()){
            if(c == 'a'){
                answer += Character.toString(c).toUpperCase();
            }else{
                answer += Character.toString(c);   
            }
        }
        
        return answer;
    }
}