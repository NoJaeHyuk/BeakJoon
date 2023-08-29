import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= n; i++){
            q.offer(i);
        }

        while(!q.isEmpty()){
            int q_leng = q.size();
            answer++;
            for(int i = 0; i < q_leng/2; i++){
                int c1 = q.poll();
                int c2 = q.poll();

                if((c1 == a || c2 == a) && (c1 == b || c2 == b)) {
                    q.clear();
                    break;
                }

                if(c1 == a || c2 == a){
                    q.offer(a);
                }else if(c1 == b || c2 == b){
                    q.offer(b);
                }else{
                    q.offer(c1);
                }
            }
        }

        return answer;
    }
}