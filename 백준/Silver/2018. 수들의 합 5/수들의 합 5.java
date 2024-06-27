import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int arr[] = new int[N];
        int s_i = 1, e_i = 1, sum=1, cnt=1;

        while(s_i<N){
            if(sum>N){
                sum -= s_i;
                s_i ++;
            }else if(sum<N){
                e_i++;
                sum += e_i;
            }else{
                e_i++;
                sum +=e_i;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
