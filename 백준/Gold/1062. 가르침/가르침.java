import java.util.*;

public class Main{
    static boolean[] alph = new boolean[26];
    static String[] words;
    static int max = 0;
    static int n,k;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        words = new String[n];
        for(int i=0;i<n;i++){
            String str = sc.next();
            words[i] = str.replace("anta","").replace("tica","");
        }
        if(k<5){ //a,n,t,i,c
            System.out.println(0);
            return;
        }else if(k==26){ //모든 알파벳 존재 
            System.out.println(n);
            return;
        }
        char[] ch = new char[]{'a','n','t','i','c'};
        for(int i=0;i<5;i++){
            alph[ch[i]-'a'] = true;
        }
        
        bt(0,0);
        System.out.println(max);
    }
    
    static void bt(int idx,int len){
        if(len==k-5){
            int cnt=0;
            for(String word:words){
                boolean flag = true;
                for(int i=0;i<word.length();i++){
                    char ch = word.charAt(i);
                    if(!alph[ch-'a']){
                        flag = false;
                        break;
                    }
                }
                if(flag) cnt++;
            }
            max = Math.max(max,cnt);
            return;
        }
        for(int i=idx;i<26;i++){
            if(!alph[i]){
                alph[i] = true;
                bt(i+1,len+1);
                alph[i] = false;
            }
        }
    }
}