import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a;
        int b;

        String str;
        StringTokenizer st;
        while ((str = br.readLine()) != null){
            st = new StringTokenizer(str," ");

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            bw.write((a+b)+"\n");
        }

        bw.flush();
        bw.close();
    }
}
