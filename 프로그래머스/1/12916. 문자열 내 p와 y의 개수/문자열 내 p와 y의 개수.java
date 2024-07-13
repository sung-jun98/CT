class Solution {
    //1. P, p의 개수를 세서 변수1에 적재
    //2. Y, y의 개수를 세서 변수2에 적재
    //3. 변수1, 변수2의 값의 일치 여부 비교
    
    boolean solution(String s) {
        boolean answer = true;
        int num_of_p = 0;
        int num_of_y = 0;

        //System.out.println(s.length());
        for(int i=0; i<s.length(); i++){
            if (s.charAt(i) == 'p' || s.charAt(i) == 'P'){
                //System.out.println(s.charAt(i));
                num_of_p += 1;
            } else if(s.charAt(i) == 'y' || s.charAt(i) == 'Y'){
                num_of_y += 1;
            }
        }
        
        if (num_of_p == num_of_y){
            answer = true;
        } else {
            answer = false;
        }
        
        return answer;
    }
}