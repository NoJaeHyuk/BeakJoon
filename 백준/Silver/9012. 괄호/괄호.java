import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            char[] st = br.readLine().toCharArray();
            Stack<Integer> stack = new Stack<>();

            Boolean check = true;

            for(int j=0; j<st.length; j++){
                if(st[j] == '('){
                    stack.push(1);
                }else{
                    if(stack.size() == 0){
                        check = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if(stack.size() == 0 && check){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }

    }
}
