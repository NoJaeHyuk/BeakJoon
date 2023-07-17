import java.io.*;
import java.lang.Math;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine();

        Double A;
        Double B;

        String[] ab = a.split(" ");

        A = Double.valueOf(ab[0]);
        B = Double.valueOf(ab[1]);

        Double adf = Double.valueOf(A/B);

        System.out.println(adf);

    }
}