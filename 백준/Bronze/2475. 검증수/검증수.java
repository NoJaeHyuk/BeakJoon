import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int sum = 0;
        for (String input : inputs) {
            sum += Math.pow(Double.parseDouble(input), 2 );
        }
        
        int remain = sum % 10;
        System.out.println(remain);
    }
}
