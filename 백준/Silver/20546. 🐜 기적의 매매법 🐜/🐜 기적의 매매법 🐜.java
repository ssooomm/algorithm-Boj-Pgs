import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stock = new int[14];
        for(int i=0;i<14;i++){
            stock[i] = sc.nextInt();
        }

        int num1 = 0, num2 = 0, m1=n,m2=n;
        int up = 0, down = 0;

        for(int i=0;i<14;i++){
            if(m1>=stock[i]){
                num1+= m1/stock[i];
                m1%=stock[i];
            }

            // 성민이는 첫째날 패스
            if(i==0) continue;

            if(stock[i-1]<stock[i]){
                up++;
                down=0;
            }
            else if(stock[i-1]==stock[i]) continue; //전일과 동일하면 상승도 하락도 아님
            else{
                down++;
                up=0;
            }

            if(up==3){
                if(num2>0){
                    m2+=num2*stock[i];
                    num2=0;
                }
            }
            else if(down==3){
                if(m2>=stock[i]){
                    num2+= m2/stock[i];
                    m2%=stock[i];
                }
            }
        }

        int l1 = m1+(stock[13]*num1);
        int l2 = m2+(stock[13]*num2);

        if(l1>l2) System.out.println("BNP");
        else if(l1<l2) System.out.println("TIMING");
        else System.out.println("SAMESAME");
    }
}