
import java.util.Scanner;

public class Main {
    static boolean visit[];
    static int[][] S;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        S = new int[N][N];
        visit = new boolean[N];

        for(int i = 0; i<N; i++){
            for (int j = 0; j<N; j++){
                S[i][j] = sc.nextInt();
            }
        }

        solve(N,0);
        System.out.println(MIN);
    }

    public static void solve(int N, int count){
        if(count == N){
            int start_team = 0;
            int link_team = 0;

            for(int i = 0; i < N; i++){
                for(int j = i+1; j < N; j++){
                    if(visit[i] == true && visit[j] == true){
                        start_team += S[i][j] + S[j][i];
                    }else if(visit[i] == false && visit[j] == false){
                        link_team += S[i][j] + S[j][i];
                    }
                }
            }
            int val = Math.abs(start_team - link_team);
            MIN = Math.min(val,MIN);

            return;
        }

        visit[count] = true;
        solve(N,count+1);
        visit[count] = false;
        solve(N,count+1);
    }
}
