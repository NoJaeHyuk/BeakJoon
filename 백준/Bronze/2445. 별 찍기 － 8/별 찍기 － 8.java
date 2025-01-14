import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j <= (n * 2); j++) {
                if (j <= i || j > n * 2 - i) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            System.out.println(sb);
        }

        for (int i = n - 1; i >= 1; i--) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j <= (n * 2); j++) {
                if (j <= i || j > n * 2 - i) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            System.out.println(sb);
        }
    }
}
