class Solution {
    public int[] solution(String myString) {
        String[] lengStr = myString.split("x");
        
        int[] answer = new int[lengStr.length];
        
        if(myString.lastIndexOf("x") == myString.length()-1){
            answer = new int[lengStr.length+1];
        }
        
        for(int i = 0; i < lengStr.length; i++){
            answer[i] = lengStr[i].length();
        }
        
        return answer;
    }
}