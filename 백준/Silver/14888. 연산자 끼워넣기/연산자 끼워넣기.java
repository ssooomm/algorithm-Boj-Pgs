import java.util.*;

public class Main{
    static int n;
    static int[] num;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        num = new int[n];
        for(int i=0;i<n;i++){
            num[i] = sc.nextInt();
        }
        int[] opr =new int[4];
        for(int i=0;i<4;i++){
            opr[i] = sc.nextInt();
        }

        dfs(opr,num[0],1);
        Collections.sort(list);

        System.out.println(list.get(list.size()-1));
        System.out.println(list.get(0));


    }
    static void dfs(int[] opr, int sum, int idx){
        if(idx==n){
            list.add(sum);
            return;
        }
        if(opr[0]>0){
            sum+=num[idx];
            opr[0]--;
            dfs(opr,sum,idx+1);
            opr[0]++;
            sum-=num[idx];
        }
        if(opr[1]>0){
            sum-=num[idx];
            opr[1]--;
            dfs(opr,sum,idx+1);
            opr[1]++;
            sum+=num[idx];
        }
        if(opr[2]>0){
            sum*=num[idx];
            opr[2]--;
            dfs(opr,sum,idx+1);
            opr[2]++;
            sum/=num[idx];
        }
        if(opr[3]>0){
            sum/=num[idx];
            opr[3]--;
            dfs(opr,sum,idx+1);
            opr[3]++;
            sum*=num[idx];
        }
    }


}