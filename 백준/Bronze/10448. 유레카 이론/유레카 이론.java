import java.util.*;

public class Main{
    static int[] tri = new int[45];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for(int i=1;i<45;i++){
            tri[i] = i*(i+1)/2;
        }
        
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            //int sq = (int)Math.sqrt(2*n);
            
            System.out.println(eureka(n));
        }
    }
    
    static int eureka(int n){
        for(int i=1;i<43;i++){
            for(int j=i;j<44;j++){
                for(int z=j;z<45;z++){
                    int sum=tri[i]+tri[j]+tri[z];
                    if(sum==n){
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
}