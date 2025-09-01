import java.util.*;
public class Main{
    static int l,c;
    static char[] arr;
    static boolean[] v;
    static StringBuilder res = new StringBuilder();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        l = sc.nextInt();
        c = sc.nextInt();
        arr = new char[c];
        v = new boolean[c];
        for(int i=0;i<c;i++){
            arr[i] = sc.next().charAt(0);
        }
        Arrays.sort(arr);
        bt(0,new ArrayList<>());
        System.out.println(res);
    }
    
    static void bt(int idx,List<Character> str){
        if(str.size()==l){
            int j=0,m=0;
            StringBuilder sb = new StringBuilder();
            for(char ch:str){
                if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') m++;
                else j++;
                sb.append(ch);
            }
            if(m>=1&&j>=2){
                res.append(sb+"\n");
            }
            return;
        }
        
        for(int i=idx;i<c;i++){
            if(!v[i]){
                str.add(arr[i]);
                v[i] = true;
                bt(i+1,str);
                v[i] = false;
                str.remove(str.size()-1);
            }
        }
        
    }

}