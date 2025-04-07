import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        String s = sc.next();
        int z = 0;
        int o = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                sb.append('1');
                o++;
            }else{
                sb.append('0');
                z++;
            }
        }
        o/=2;
        z/=2;
        
        //1은 앞에서부터 제거
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='1'){
                sb.setCharAt(i,'2');
                o--;
            }
            if(o==0) break;
        }
        
        //0은 뒤에서부터 제거
        for(int i=sb.length()-1;i>=0;i--){
            if(sb.charAt(i)=='0'){
                sb.setCharAt(i,'2');
                z--;
            }
            if(z==0) break;
        }
        
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='0'||sb.charAt(i)=='1'){
                ans.append(sb.charAt(i));
            }
        }
        System.out.println(ans);
    }
}