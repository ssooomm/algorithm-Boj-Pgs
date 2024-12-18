import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Queue<Integer> q = new ArrayDeque<>();
        while(N-- >0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch(st.nextToken()){
                case "push":
                    q.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(q.isEmpty()) System.out.println(-1);
                    else System.out.println(q.remove());
                    break;
                case "size":
                    System.out.println(q.size());
                    break;
                case "empty":
                    if(q.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;
                case "front":
                    if(q.isEmpty()) System.out.println(-1);
                    else System.out.println(q.peek());
                    break;
                case "back":
                    if(q.isEmpty()) System.out.println(-1);
                    else System.out.println(((Deque<Integer>) q).getLast());
                    break;
            }
        }
    }
}