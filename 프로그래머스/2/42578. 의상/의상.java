import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        // 의상 종류별로 의상의 개수를 세기 위해 HashMap 사용
        Map<String, Integer> clothesMap = new HashMap<>();
        
        // 의상 종류별로 개수를 세어 HashMap에 저장
        for (String[] cloth : clothes) {
            String type = cloth[1];
            clothesMap.put(type, clothesMap.getOrDefault(type, 0) + 1);
        }
        
        // 모든 종류의 의상 개수에 대해 (해당 의상을 입지 않는 경우 + 1)을 모두 곱해줌
        int combinations = 1;
        for (int count : clothesMap.values()) {
            combinations *= (count + 1);
        }
        
        // 모든 경우의 수에서 아무 것도 입지 않는 경우 하나를 제외
        answer = combinations - 1;
        
        return answer;
    }
}
