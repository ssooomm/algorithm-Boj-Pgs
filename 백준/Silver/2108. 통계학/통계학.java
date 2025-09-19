import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        arr[0] = -4001;
        double sum=0;
        
        Map<Integer, Integer> map = new HashMap<>();
        int max=0;
        for(int i=1;i<=n;i++){
            arr[i] = sc.nextInt();
            sum+=arr[i];
            
            int tmp = map.getOrDefault(arr[i],0)+1;
            map.put(arr[i],tmp);
            max = Math.max(max,tmp);
        }
        
        Arrays.sort(arr);
        System.out.println(Math.round(sum/n));
        
        int mid = (n+1)/2;
        System.out.println(arr[mid]);
        
        List<Integer> list = new ArrayList<>();
        for(int k:map.keySet()){
            if(map.get(k)==max){
                list.add(k);
            }
        }
        if(list.size()==1) System.out.println(list.get(0));
        else{
            Collections.sort(list);
            System.out.println(list.get(1));
        }
        
        System.out.println(arr[n]-arr[1]);
        
    }
}