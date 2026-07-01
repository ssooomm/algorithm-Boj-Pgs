import java.util.*;

class Solution {
    
    //학생 당 16가지 조건씩, 앞에 4가지 일치하는 학생들의 점수만 저장
    static Map<String,List<Integer>> map = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        int in = info.length;
        int qn = query.length;
        int[] answer = new int[qn];
        
        //사람당 가질 수 있는 16가지 조합 저장
        for(String i:info){
            String[] arr = i.split(" ");
            int score = Integer.parseInt(arr[4]);
            make(arr,"",0,score);
        }
        
        //점수 정렬
        for(String k:map.keySet()){
            Collections.sort(map.get(k));
        }
        
        for(int i=0;i<qn;i++){
            String q = query[i].replace(" and ",""); //map에 저장된 k값 처럼 문자열 생김
            String[] arr = q.split(" ");
            
            String key = arr[0];
            int target = Integer.parseInt(arr[1]);
            
            if(!map.containsKey(key)){
                answer[i] = 0;
                continue;
            }
            
            //이진탐색
            List<Integer> list = map.get(key);
            answer[i] = list.size()-binary(list,target);
        }
        
        return answer;
    }
    
    public void make(String[] arr, String str, int depth, int score){
        if(depth==4){
            map.computeIfAbsent(str,k->new ArrayList<>()).add(score);
            //없으면 계산해서 map에 넣어라 -> 해당 k가진 map만들어지고 객체 생성해서 점수 들어감, 이미 k있으면 무시
            return;
        }
        //원본 조건
        make(arr,str+arr[depth],depth+1,score);
        //하이픈
        make(arr,str+"-",depth+1,score);
    }
    
    public int binary(List<Integer> list, int target){
        int l = 0;
        int r = list.size();
        
        while(l<r){
            int mid = (l+r)/2;
            if(list.get(mid)>=target){
                r = mid;
            }else
                l = mid+1;
        }
        
        return l;
    }
}