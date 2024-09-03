import java.util.*;
import java.io.*;

/*
1
8 3
0 0 0 0 0 1 0 0
0 1 0 1 0 0 0 1
0 0 0 0 0 0 0 0
0 0 0 1 0 1 0 0
0 0 1 1 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 1 0 1 0
1 0 0 0 0 0 0 0
 */
public class Solution {
    static int N, M; // 도시의 크기, 하나의 집이 지불할 수 있는 비용
    static int[][] city; // 도시의 정보
    static int maxHouses; // 회사가 얻을 수 있는 최대의 이익중, 집의 수
    static int operateFee;

//    static int[] dx = { -1, 0, 1, 0, -1, 1, 1, -1 }; // 북 동 서 남 북동 남동 서남 북서
//    static int[] dy = { 0, 1, 0, -1, 1, 1, -1, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            city = new int[N][N];
            operateFee = 0;
            maxHouses = 0;
            int maxK = N + 1;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    city[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 영역을 구하는 메서드
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int K = 1; K <= maxK; K++) {
                        getArea(K, i, j);
                    }
                }
            }
            System.out.println("#" + t + " " + maxHouses);
        }
    }

    // 영역을 구하는 메서드
    private static void getArea(int K, int x, int y) {
        // 현재 시점의 운영비용 계산
        operateFee = K * K + (K - 1) * (K - 1);
        ArrayList<int[]> area = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int absX = Math.abs(x - i);
                int absY = Math.abs(y - j);
                int dist = absX + absY;
                if (dist < K) {
                    area.add(new int[] { i, j });
                }
            }
        }

//        for (int j = 0; j < area.size(); j++) {
//            System.out.println(Arrays.toString(area.get(j)));
//        }
        findHouse(area);
    }

    // 구한 영역 내부의 집들을 찾는 메서드
    private static void findHouse(ArrayList<int[]> area) {
        int houseNum = 0;
        // 집의 개수 구하기
        for (int[] house : area) {
            int x = house[0];
            int y = house[1];
            if (isIn(x, y) == true && city[x][y] == 1) {
                houseNum += 1;
            }
        }
        // System.out.println(houseNum);
        // 집의 개수를 바탕으로 얻을 수 있는 최고 수익 구하기
        getPrice(houseNum);
    }

    // 구한 집이 도시 범위 내에 있는가
    private static boolean isIn(int x, int y) {
        return 0<= x && x < N && 0 <= y && y < N;
    }

    private static void getPrice(int houseNum) {
        if(houseNum * M >= operateFee){
            if(houseNum > maxHouses){
                maxHouses = houseNum;
            }
        }
//        int benefit = (M * houseNum) - operateFee;
//
//        if (benefit > maxBenefit) {
//            System.out.println(houseNum + " " + benefit + " " + operateFee);
//            maxBenefit = benefit;
//        }
        // System.out.println(maxBenefit);
    }

}
