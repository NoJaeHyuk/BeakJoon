import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        int a;
        int b;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken()); //첫번째 호출
            b = Integer.parseInt(st.nextToken()); //두번째 호출
            sb.append(a+b+"\n");
        }

        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        wr.write(sb.toString());
        wr.flush();
        wr.close();
    }
}
