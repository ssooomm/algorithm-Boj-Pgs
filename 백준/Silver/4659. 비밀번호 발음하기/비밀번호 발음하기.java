import java.util.*;
import java.io.*;

public class Main{
    static String moem = "aeiou";
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String str = br.readLine();
            if(str.equals("end")) break;
            else{
                if(check(str)){
                    sb.append("<"+str+"> is acceptable.\n");
                }else{
                    sb.append("<"+str+"> is not acceptable.\n");
                }
            }
        }
        System.out.println(sb);
    }
    static boolean check(String str){
        String[] arr = str.split("");
        int m=0, j=0;
        boolean flag=false;
        String ch = "";
        for(int i=0;i<arr.length;i++){
            if(ch.equals(arr[i])){
                if(!ch.equals("e")&&!ch.equals("o")){
                    return false;
                }
            }else{
                ch=arr[i];
                if(moem.contains(arr[i])){
                    flag = true;
                    j=0;
                    m++;
                    if(m==3) return false;
                }
                else{
                    m=0;
                    j++;
                    if(j==3) return false;
                }
            }
        }
        if(!flag) return false;
        else return true;
    }
}