import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int len = str.length();
        int cnt=len-1;
        
        for(int i=0;i<cnt;i++){
            if(isp(str.substring(i))){
                cnt=i;
                break;
            }
        }
        System.out.println(len+cnt);
    }
    
    static boolean isp(String str){
        int l=0;
        int r = str.length()-1;
        while(l<r){
            if(str.charAt(l)!=str.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}