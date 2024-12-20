import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        Deque<Character> dq = new ArrayDeque<>();

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='<'){
                while(!dq.isEmpty()){
                    sb.append(dq.removeLast());
                }
                dq.addLast('<');
            }
            else if(str.charAt(i)=='>'){
                while(!dq.isEmpty()){
                    sb.append(dq.removeFirst());
                }
                sb.append('>');
            }

            else if(str.charAt(i)==' '){
                if(dq.contains('<')){
                    dq.addLast(' ');
                }
                else{
                    while(!dq.isEmpty()){
                        sb.append(dq.removeLast());
                    }
                    sb.append(' ');
                }
            }
            else dq.addLast(str.charAt(i));
        }
        while(!dq.isEmpty()){
            sb.append(dq.removeLast());
        }
        System.out.println(sb);
    }
}