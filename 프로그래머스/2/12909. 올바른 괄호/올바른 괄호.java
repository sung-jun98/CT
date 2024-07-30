import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
//0. 맨 처음 나온 char가 '('이라면,
//1. '('이 나온다면 stack에 넣는다.
//2. ')'이 나온다면 stack에서 뺸다.
//3. 맨 마지막까지 했을떄, stack이 비어있지 않다면 false, 비어있다면 true
class Solution {
    boolean solution(String s) {
        Deque<Character> deque = new LinkedList<>();
        boolean answer = true;
        char first = s.charAt(0);

        if(s.charAt(0) == ')'){
            answer = false;
            return answer;
        }
        
        for(char i : s.toCharArray()){
            if(i == first){
                deque.addLast(i);
            }else if(i != first && deque.isEmpty()){
                deque.addLast(i);
            }else if(i != first && !deque.isEmpty()){
                deque.removeLast();
            }

        }
        if(deque.isEmpty()){
            answer = true;
        }else{
            answer = false;
        }
        return answer;
    }
}