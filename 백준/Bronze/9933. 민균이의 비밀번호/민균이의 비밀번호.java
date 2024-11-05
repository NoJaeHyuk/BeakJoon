import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        String result = null;

        for (int i = 0; i < n; i++) {
            String text = br.readLine();
            String reverseText = new StringBuilder(text).reverse().toString();

            // Check if the string is a palindrome
            if (text.equals(reverseText)) {
                result = text.length() + " " + text.charAt(text.length() / 2);
                break;
            }

            // Check if the reverse of the string has been seen before
            if (set.contains(reverseText)) {
                result = text.length() + " " + text.charAt(text.length() / 2);
                break;
            }

            set.add(text);
        }

        // Print the result if found
        if (result != null) {
            System.out.println(result);
        }
    }
}
