import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] ary = new long[N];
        long left = 0;
        long right = 0;
        long sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            ary[i] = Integer.parseInt(st.nextToken());
            sum += ary[i];
            right = Math.max(ary[i],right);
        }

        int total = Integer.parseInt(br.readLine());

        if(sum > total){
            while (left <= right){
                long mid = (left+right)/2; // 세금의 상환선
                long result = 0;
                for(int i=0; i<N; i++){
                    if(mid < ary[i]){
                        result += mid;
                    }else{
                        result += ary[i];
                    }
                }

                if(result <= total){
                    left = mid+1;
                    max = Math.max(mid,max);
                }else{
                    right = mid-1;
                }
            }
            System.out.println(right);
        }else{
            System.out.println(right);
        }

    }
}
