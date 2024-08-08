import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int answer = 0;
        List<List<Integer>> res = new ArrayList<>();
        int row = relation.length;
        int col = relation[0].length;
        for(int i=1;i<=col;i++){
            backtrack(relation, col, i, 0, new ArrayList<>(), res);
        }
        return res.size();
    }
    
    void backtrack(String[][] relation, int n, int k, int st, List<Integer> cur,List<List<Integer>> res){
        if(k==cur.size()){
            boolean common = false;
            for(List<Integer> l:res){
                for(int next:l){
                    if (cur.contains(next)) {
                        common = true;
                    }
                    else{
                        common = false;
                        break;
                    }
                    // if(cur.contains(next)){
                    //     common = true;
                    //     break;
                    // }
                }
                if(common){break;}
            }
            if(!common){
                Set<String> tmp = new HashSet<>();
                for(String[] r:relation){
                    String str = "";
                    for(int c:cur){
                        str+=r[c]+"_";
                    }
                    tmp.add(str);
                }
                if(tmp.size()==relation.length){
                    res.add(new ArrayList<>(cur));
                }
            }
            return;
        }
        for(int i=st;i<n;i++){
            cur.add(i);
            backtrack(relation, n, k, i+1, cur, res);
            cur.remove(cur.size()-1);
        }
    }
}