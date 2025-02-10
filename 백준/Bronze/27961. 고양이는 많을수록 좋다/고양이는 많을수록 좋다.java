import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        int count = 0;
        long catSum = 0;

        // 두가지 경우가 존재
        while (n != catSum) {
            count++;
            if (catSum == 0) {
                catSum = 1;
            } else {
                if (n - catSum < catSum) {
                    catSum += n - catSum;
                } else {
                    catSum += catSum;
                }
            }
        }

        System.out.println(count);
    }
}
