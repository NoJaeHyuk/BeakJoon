import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        String line = br.readLine();

        int count = 0;

        for (String str : split) {
            if (str.equals(line)) {
                continue;
            }
            if (str.contains(line)) {
                if (str.substring(0, line.length()).equals(line)) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
