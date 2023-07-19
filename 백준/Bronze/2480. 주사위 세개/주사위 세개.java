import java.util.Scanner;

/**
 * 입력값 중 같은 값이 몇개인지 확인한다.
 * 몇개인지 확인했으면 조건에 맞는 상금을 계산해 표출한다.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int cnt = 0;
        int re = 0 ;

        if(a == b){
            cnt++;
            re = a;
        }

        if (a == c) {
            cnt++;
            re = a;
        }

        if (b == c) {
            cnt++;
            re = b;
        }

        if(cnt > 2 ){
            System.out.println(10000+re*1000);
        } else if (cnt == 1) {
            System.out.println(1000+re*100);
        } else {
            int max = Math.max(a,b);
            max = Math.max(max,c);
            System.out.println(max*100);
        }
    }
}
