import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ", 3);
            String key = arr[2].substring(0, 5);

            map.put(key, map.containsKey(key) ? "?" : arr[1]);
        }


        for (int j = 0; j < m; j++) {
            String result = br.readLine();
            if(map.containsKey(result)){
                System.out.println(map.get(result));
            }else {
                System.out.println("!");
            }
        }
    }
}
