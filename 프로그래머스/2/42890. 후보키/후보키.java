import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int answer = 0;
        
        int col = relation[0].length;
        int row = relation.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i=1;i<=col;i++){
            backtrack(col,i,0,new ArrayList<>(), res, relation);
        }
        return res.size();
    }
    
    void backtrack(int n, int k, int st, List<Integer> curr, List<List<Integer>> res, String[][] relation){
        if(curr.size()==k){
            boolean hasCommon = false;
            for(List<Integer> sub:res){
                for(int num: sub){
                    if(curr.contains(num)){
                        hasCommon = true;
                    }else{
                        hasCommon = false;
                        break;
                    }
                }
                if(hasCommon) break;
            }
            if(!hasCommon){
                Set<String> set = new HashSet<>();
                for(int j=0;j<relation.length;j++){
                    String tmp = "";
                    for(int i:curr){
                        tmp += relation[j][i] + "_";
                    }
                    set.add(tmp);
                }
                if(set.size()==relation.length){
                    res.add(new ArrayList<>(curr));
                }
            }
            return;
        }
        
        for(int i=st;i<n;i++){
            curr.add(i);
            backtrack(n,k,i+1,curr,res,relation);
            curr.remove(curr.size()-1);
        }
    }
}