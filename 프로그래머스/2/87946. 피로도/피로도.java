class Solution {
    static int ans=0;
    public int solution(int k, int[][] dungeons) {
        int len = dungeons.length;
        bt(dungeons,k,0,new boolean[len]);
        return ans;
    }
    
    void bt(int[][] dungeons,int cur,int cnt,boolean[] v){
        for(int i=0;i<dungeons.length;i++){
            if(!v[i]){
                int[] tmp = dungeons[i];
                if(cur<tmp[0]){
                    continue;
                }
                v[i] = true;
                bt(dungeons,cur-tmp[1],cnt+1,v);
                v[i] = false;
            }
        }
        ans = Math.max(ans,cnt);
        return;
    }
}