import java.util.*;

class Solution {
    public String solution(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        // 각 문자의 빈도 계산
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        // 한 번만 등장한 문자 추출
        List<Character> result = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        
        // 사전 순 정렬
        Collections.sort(result);
        
        // 리스트를 문자열로 변환
        StringBuilder answer = new StringBuilder();
        for (char c : result) {
            answer.append(c);
        }
        
        return answer.toString();
    }
}
