import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] count = new int[100001];
    static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] num_array = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            num_array[i] = Integer.parseInt(st.nextToken());
        }

        solve(num_array,K);


        System.out.println(MAX);
    }

    public static void solve(int[] arr, int K){
        int left = 0;
        int right = 0;

        while (right < arr.length){
            while (right < arr.length && count[arr[right]]+1 <= K){
                count[arr[right]]++;
                right++;
            }

            int leng = right-left;
            MAX = Math.max(MAX,leng);
            count[arr[left]]--;
            left++;
        }
    }
}
