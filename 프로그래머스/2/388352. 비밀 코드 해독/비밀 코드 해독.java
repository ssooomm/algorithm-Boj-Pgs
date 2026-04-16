import java.util.*;

class Solution {
    static List<List<Integer>> all = new ArrayList<>();
    static int n;
    public int solution(int n, int[][] q, int[] ans) {
        this.n = n;
        bt(new ArrayList<>(), 1);
        
        int res=0;
        boolean flag = false;
        
        for(List<Integer> a:all){
            flag = false;
            for(int i=0;i<q.length;i++){
                int cnt=0;
                for(int j:q[i]){
                    if(a.contains(j)) cnt++;
                    if(cnt>ans[i]){
                        flag= true;
                        break;
                    }
                }
                if(cnt!=ans[i]) flag = true;
                if(flag) break;
            }
            if(!flag) res++;
        }
        
        return res;
    }
    
    public void bt(List<Integer> list, int st){
        if(list.size()==5){
            all.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=st;i<=n;i++){
            list.add(i);
            bt(list,i+1);
            list.remove(list.size()-1);
        }
    }

}