import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] a;
    static int MIN = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        a = new boolean[N][M];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                if(str.charAt(j) == 'W'){
                    a[i][j] = true;
                }else{
                    a[i][j] = false;
                }
            }
        }

        //8x8 만들수 있는 경우의 수
        int r1 = N - 7;
        int r2 = M - 7;

        for(int i = 0; i < r1; i++){
            for(int j = 0; j < r2; j++){
                find(i,j);
            }
        }

        System.out.println(MIN);
    }

    public static void find(int i, int j){
        int end_x = i + 8;
        int end_y = j + 8;
        int count = 0;

        //첫 위치가 기준
        boolean chk = a[i][j];

        for(int i1 = i; i1<end_x; i1++) {
            for (int j1 = j; j1 < end_y; j1++) {
                if (a[i1][j1] != chk) {
                    count++;
                }

                //다음 순서의 값 지정 한다고 생각하자
                chk = !chk;
            }
            //새로운 행의 시작은 반대이므로 해당 처리
            chk = !chk;
        }

        count = Math.min(count,64-count);

        MIN = Math.min(MIN,count);
    }
}
