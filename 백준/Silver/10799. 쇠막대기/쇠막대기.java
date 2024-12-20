import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Deque<String> stack = new ArrayDeque<>();
        int cnt=0;
        String[] arr = sc.next().split("");

        for(int i=0; i<arr.length; i++){
            if(arr[i].equals("(")){
                if(arr[i+1].equals(")")){
                    if(!stack.isEmpty()){
                        cnt+=stack.size();
                        i+=1;
                    }
                }else{
                    stack.push("(");
                }
            }
            else{
                if(!stack.isEmpty()){
                    //
                    cnt++;
                    stack.pop();
                }
            }
        }
        System.out.println(cnt);
    }
}