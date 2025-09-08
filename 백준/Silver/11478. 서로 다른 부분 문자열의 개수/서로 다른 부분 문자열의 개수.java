import java.util.*;

public class Main{
    static int cnt=0, len=0;
    static char[] arr;
    static Set<String> set = new HashSet<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        len = str.length();
        arr = new char[len];
        for(int i=0;i<len;i++){
            arr[i] = str.charAt(i);
        }
        
        for(int i=1;i<=len;i++){
            for(int j=0;j<=len-i;j++){
                bt(j,i);
            }
        }
        
        System.out.println(set.size());
    }
    
    static void bt(int idx, int size){
        StringBuilder sb = new StringBuilder();
        for(int i=idx;i<idx+size;i++){
            sb.append(arr[i]);
        }
        set.add(sb.toString());
    }
}