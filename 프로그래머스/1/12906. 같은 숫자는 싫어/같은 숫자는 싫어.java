import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        //int[] answer = {};
        List<Integer> result = new ArrayList<>();
        int prev = arr[0];
        result.add(prev);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != prev) {
                result.add(arr[i]);
                prev = arr[i];
            }
        }

        // List를 배열로 변환
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
        
        
    }
}