import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] arr = new int[2];
        char pre = str.charAt(0);
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)=='1'){
                if(pre!='1'){
                    pre='1';
                    arr[0]++;
                }
            }
            else if(str.charAt(i)=='0'){
                if(pre!='0'){
                    pre='0';
                    arr[1]++;
                }
            }
        }
        arr[pre-'0']++;
        
        System.out.println(Math.min(arr[0],arr[1]));
    }
}