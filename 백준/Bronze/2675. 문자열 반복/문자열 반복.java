import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int count = Integer.parseInt(st.nextToken());
            String text = st.nextToken();

            for(char ch : text.toCharArray()) {
                String str = String.valueOf(ch);
                sb.append(str.repeat(count));
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
