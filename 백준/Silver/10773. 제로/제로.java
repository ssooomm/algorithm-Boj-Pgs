import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        Deque<Integer> stack = new ArrayDeque<>();
        while(k-->0){
            int tmp = sc.nextInt();
            if(tmp==0){
                stack.pop();
            }else{
                stack.push(tmp);
            }
        }

        int res=0;
        for(int i:stack){
            res+=i;
        }
        System.out.println(res);
    }
}