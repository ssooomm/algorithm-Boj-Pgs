import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.next().split("-");
        
        List<Integer> list = new ArrayList<>();
        for(String str:arr){
            int sum=0;
            String[] num = str.split("\\+");
            for(String n:num){
                sum+=Integer.parseInt(n);
            }
            list.add(sum);
        }
        
        int res=list.get(0);
        for(int i=1;i<list.size();i++){
            res-=list.get(i);
        }
        System.out.println(res);
    }
}