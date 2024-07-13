class Solution {
    
    public long solution(int a, int b) {
        int tmp = 0;
        long answer = 0;
        
        //만약 앞의 수가 더 클 경우, 뒤로 보내준다.
        if (a > b){
            tmp = a;
            a = b;
            b = tmp;
        }
        
        for (int i=a; i<=b; i++){
            answer += i;
        }
        if (a == b){
            answer = a;
        }
        return answer;
    }
}