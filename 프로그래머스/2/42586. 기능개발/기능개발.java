import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
    //1. progresses의 모든 요소를 100에서 뺸 값을 proTemp 배열에 저장
    //2. proTemp 배열의 모든 요소를 speeds로 나눈다 -> dayLefts deque에 저장
    //3. deque에서 하나씩 빼되, int 타입의 datCnt
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Deque<Integer> dayLefts = new LinkedList<>();

        // 1. 작업 완료까지 남은 일수를 계산하여 deque에 저장
        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            int daysLeft = (int) Math.ceil((100.0 - progress) / speed);
            dayLefts.addLast(daysLeft);
        }

        // 2. 배포 일수를 계산하고 결과를 저장
        while (!dayLefts.isEmpty()) {
            int currentDeployDay = dayLefts.removeFirst(); // 현재 기능의 배포일까지 남은 일수
            int deployCount = 1; // 현재 기능은 최소 1개의 배포 기능을 포함

            // 현재 기능이 배포된 날에 함께 배포되는 기능을 계산
            while (!dayLefts.isEmpty() && dayLefts.peekFirst() <= currentDeployDay) {
                dayLefts.removeFirst();
                deployCount++;
            }

            answer.add(deployCount);
        }


        // 3. 결과를 int 배열로 변환
        return answer.stream().mapToInt(Integer::intValue).toArray();
}
}