class Solution {
    public int solution(String binomial) {
        int answer = 0;
        
        String[] binomials = binomial.split(" ");
        
        if(binomials[1].equals("+")){
            answer = Integer.parseInt(binomials[0]) + Integer.parseInt(binomials[2]);
        }else if(binomials[1].equals("-")){
            answer = Integer.parseInt(binomials[0]) - Integer.parseInt(binomials[2]);
        }else{
            answer = Integer.parseInt(binomials[0]) * Integer.parseInt(binomials[2]);
        }
        
        return answer;
    }
}