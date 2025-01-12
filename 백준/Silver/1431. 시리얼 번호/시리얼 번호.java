import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.next();
        }

        Arrays.sort(arr,(e1,e2)->{
            if(e1.length()==e2.length()){
                int sum1=0, sum2=0;
                for(int i=0;i<e1.length();i++){
                    int num1 = e1.charAt(i) - '0';
                    int num2 = e2.charAt(i) - '0';
                    if(num1<=9) sum1+=num1;
                    if(num2<=9) sum2+=num2;
                }
                if(sum1==sum2) return e1.compareTo(e2);
                else return sum1-sum2;
            }else{
                return e1.length()-e2.length();
            }
        });

        for(int i=0;i<n;i++){
            System.out.println(arr[i]);
        }
    }
}