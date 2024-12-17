

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] num = new int[N];
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            num[i] = Integer.parseInt(br.readLine());
            arr[i] = i+1;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int tmp = 0;
        for(int i=0;i<N;i++){
            if(stack.isEmpty()){
                sb.append("+\n");
                stack.push((Integer)arr[i]);
            }
            else{
                if(stack.peek()==num[tmp]){
                    sb.append("-\n");
                    stack.pop();
                    tmp++;
                    i--;
                }
                else{
                    sb.append("+\n");
                    stack.push((Integer)arr[i]);
                }
            }
        }
        while(!stack.isEmpty()){
            if(stack.peek()==num[tmp]){
                sb.append("-\n");
                stack.pop();
                tmp++;
            }
            else{
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);


    }

}
