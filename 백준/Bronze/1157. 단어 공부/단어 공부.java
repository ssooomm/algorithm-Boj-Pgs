import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch>=97){
                ch-=32;
            }
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        char ans = ' ';
        int max = 0;
        for(Character ch:map.keySet()){
            if(map.get(ch)>max){
                max = map.get(ch);
                ans = ch;
            }
            else if(map.get(ch)==max) ans = '?';
        }
        System.out.println(ans);
    }
}