import java.util.*;

public class Main{
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum=0,cnt=0,num=2;

        while(true){
            while(num<=n){
                if(sum>=n) break;
                else{
                    if(isPrime(num)){
                        sum+=num;
                        list.add(num);
                    }
                    num++;
                }
            }
            if(list.size()>0){
                if(sum==n) cnt++;
                int tmp = list.remove(0);
                sum-=tmp;
            }else break;
        }

        System.out.println(cnt);
    }

    static boolean isPrime(int x){
        if(x==1) return false;
        if(x<=3) return true;
        int tmp = (int)Math.sqrt(x);
        for(int i=2;i<=tmp;i++){
            if(x%i==0) return false;
        }
        return true;
    }
}