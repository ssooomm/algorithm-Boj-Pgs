import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = n;
        while(n-->0){
            Set<Character> set = new HashSet<>();
            String str = sc.next();
            char bch = ' ';
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                if(!set.contains(ch)){
                    set.add(ch);
                    bch = ch; 
                }
                else{
                    if(bch!=ch){
                        cnt--;
                        break;
                    } 
                }
            }
        }
        System.out.println(cnt);
    }
}