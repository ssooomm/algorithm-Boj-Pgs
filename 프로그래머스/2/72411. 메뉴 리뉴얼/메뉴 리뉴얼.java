import java.util.*;

class Solution {
    private static Map<String, Integer> setMenu;
    public String[] solution(String[] orders, int[] course) {
        List<String> res = new ArrayList<>();
        for(int size:course){
            setMenu = new HashMap<>(); //만들어진 세트메뉴는 문자열(key), 개수(value)
            for(String order:orders){
                //xya => axy 순서 정렬
                char[] sample = order.toCharArray(); //xya
                Arrays.sort(sample); //axy
                //정렬을 해서 알파벳순 => 순서가 없다
                //조합 "" -> ab ac abc
                makeCourses(0,size,"",sample);
            }
            //"abcde" ab ac ad ae ... 
            if(!setMenu.isEmpty()){
                int max = Collections.max(setMenu.values());
                if(max>1){
                    for(String key:setMenu.keySet()){
                        if(max==setMenu.get(key)){
                            res.add(key);
                        }
                    }
                }
            }
        }
        Collections.sort(res);//사전식 문자열은 -> compareTo 1 -1 0
        String[] answer = res.toArray(new String[0]); //타입으로 object -> string
        return answer;
    }
    public void makeCourses(int depth, int size, String courses, char[] order){
        if(courses.length()==size){
            if(setMenu.containsKey(courses)){
                int cnt = setMenu.get(courses);
                setMenu.put(courses, cnt+1); //ab 2 -> 3개 이미 있으면 
            }else{
                setMenu.put(courses, 1); //ab가 처음 1
            }
            return;
        }
        for(int i=depth;i<order.length;i++){
            makeCourses(i+1,size,courses+order[i],order);//a -> ab ac
        }
    }
}