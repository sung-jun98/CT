import java.util.*;

class Solution {
    static int[] info;
    static int N;
    static int[] combination;
    static int[] answer;
    static int gap;
    
     static int[] solution(int n, int[] infoInput) {
        answer = new int[11];
        N = n;
        info = infoInput;
        combination = new int[11];
        gap = Integer.MIN_VALUE;

        makeComb(0, N);
        if(Arrays.equals(answer, new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0})){
            answer = new int[] {-1};
        }
        return answer;
    }
    
    private static void makeComb(int idx, int remain) {
        // 종료조건
        if (idx == 10) {
            combination[idx] = remain;
            if (remain >= 0) {
                countGrade();
            }
            return;
        }

        // 배열에 넣을 값 조회
        for (int i = 0; i <= remain; i++) {
            combination[idx] = i;
            makeComb(idx + 1, remain - i);
        }
    }

    // 라이언과 피치의 적중률을 비교하여 점수를 계산
    private static void countGrade() {
        int lionCount = 0;
        int peachCount = 0;
        int remain = 10;

        for (int i = 0; i <= 10; i++) {
            int nLion = combination[i];
            int nPeach = info[i];
            if (nPeach + nLion != 0) {
                if (nLion > nPeach) {
                    lionCount += (remain - i);
                } else if (nLion <= nPeach) {
                    peachCount += (remain - i);
                }
            }
        }
        // 라이언과 피치의 점수의 격차가 최소인지 체크
        if (lionCount > peachCount) {
            checkGap(lionCount, peachCount);
        }
    }

    private static void checkGap(int lionCount, int peachCount) {
       int nowGap = lionCount - peachCount;
    if (nowGap > gap) {
        gap = nowGap;
        answer = combination.clone();
    } else if (nowGap == gap) {
        // 점수 차이가 같은 경우 더 낮은 점수를 많이 맞힌 배열을 선택
        for (int i = 10; i >= 0; i--) {
            if (combination[i] > answer[i]) {
                answer = combination.clone();
                break;
            } else if (combination[i] < answer[i]) {
                break;
            }
        }
    }
    }
}