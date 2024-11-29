import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String L = br.readLine();
        String text = br.readLine();

        long sum = 0;
        long power = 1;
        for (char ch : text.toCharArray()) {
            int number = (int)ch - 96;
            sum = (sum + number * power) % 1234567891;
            power = (power * 31) % 1234567891;
        }

        System.out.println(sum);
    }
}
