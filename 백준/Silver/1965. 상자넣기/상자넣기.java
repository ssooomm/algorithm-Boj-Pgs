import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        
        for(int i=1;i<n;i++){
            if(list.get(list.size()-1)<arr[i]){
                list.add(arr[i]);
            }else{
                int st = 0;
                int end = list.size()-1;
                while(st<end){
                    int mid = (st+end)/2;
                    if(list.get(mid)<arr[i]){
                        st = mid+1;
                    }else{
                        end=mid;
                    }
                }
                list.set(end,arr[i]);
            }
        }
        
        System.out.println(list.size());
    }
}