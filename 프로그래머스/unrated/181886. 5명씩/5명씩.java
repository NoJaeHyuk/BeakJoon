class Solution {
    public String[] solution(String[] names) {
        int size = names.length/5;
        
        if(names.length % 5 != 0){
            size = names.length/5 + 1;
        }
        
        String[] answer = new String[size];
        
        int j = 0;
        
        for(int i = 0; i < size; i++){
            answer[i] = names[j];
            j+=5;
        }
        
        return answer;
    }
}