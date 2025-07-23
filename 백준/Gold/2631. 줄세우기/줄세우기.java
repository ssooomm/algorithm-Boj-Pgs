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
        for(int i=0;i<n;i++){
            if(list.isEmpty()||arr[i]>list.get(list.size()-1)){
                list.add(arr[i]);
            }else{
                int l = 0, r = list.size()-1;
                while(l<r){
                    int mid = (l+r)/2;
                    if(list.get(mid)<arr[i]) l=mid+1;
                    else r = mid;
                }
                list.set(r,arr[i]);
            }
        }
        
        System.out.println(n-list.size());
    }
}