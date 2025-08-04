import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[] str = sc.next().toCharArray();
        String bomb = sc.next();
        int blen = bomb.length();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<str.length;i++){
            sb.append(str[i]);
            if(sb.length()>=blen){
                if(sb.substring(sb.length()-blen).equals(bomb)){
                    sb.delete(sb.length()-blen,sb.length());
                }
            }
        }
        
        
        System.out.println(sb.length()==0?"FRULA":sb);
    }
}