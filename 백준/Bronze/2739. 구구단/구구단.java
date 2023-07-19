import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();

        StringBuilder cu = new StringBuilder();

        int i = 1;
        while (i < 10){
            cu.append(a+" * "+i+" = "+a*i+"\n");
            i++;
        }

        System.out.println(cu);
    }
}
