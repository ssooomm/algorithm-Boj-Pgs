import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        for(int i=0;i<5;i++){
            list.add(sc.next());
        }
        StringBuilder sb = new StringBuilder();
        for(int ch=0;ch<15;ch++){
            for(String str:list){
                if(str.length()>ch){
                    sb.append(str.charAt(ch));
                }
            }
        }
        System.out.println(sb);
    }
}