import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        int len = 0;
        int len_of_set = 0;
        int answer = 0;
        
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }
        //System.out.println(set);
        len = nums.length / 2;
        len_of_set = set.size();
        
        if (len >= len_of_set){
            //System.out.println(len_of_set);
            answer = len_of_set;
        }else{
            //System.out.println(len);
            answer = len;
        }
        
        return answer;
    }
    
    
    
    
}