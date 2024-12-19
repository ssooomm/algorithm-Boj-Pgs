import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        Deque<Integer> dq = new ArrayDeque<>();
        
        while(N-- >0){
            st = new StringTokenizer(br.readLine());
            switch(st.nextToken()){
                case "push_front":
                    dq.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    dq.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if(dq.isEmpty()) System.out.println(-1);
                    else System.out.println(dq.removeFirst());
                    break;
                case "pop_back":
                    if(dq.isEmpty()) System.out.println(-1);
                    else System.out.println(dq.removeLast());
                    break;
                case "size":
                    System.out.println(dq.size());
                    break;
                case "empty":
                    if(dq.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;
                case "front":
                    if(dq.isEmpty()) System.out.println(-1);
                    else System.out.println(dq.getFirst());
                    break;
                case "back":
                    if(dq.isEmpty()) System.out.println(-1);
                    else System.out.println(dq.getLast());
                    break;
            }
        }
    }
}