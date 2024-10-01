/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        
        // 테스트 케이스 수
        int T = sc.nextInt();
        
        // 테스트 케이스마다 실행
        for (int t = 1; t <= T; t++) {
            // 물건의 개수 N, 가방의 최대 부피 K
            int N = sc.nextInt();
            int K = sc.nextInt();
            
            // 물건의 부피와 가치 배열
            int[] volumes = new int[N];
            int[] values = new int[N];
            
            for (int i = 0; i < N; i++) {
                volumes[i] = sc.nextInt();
                values[i] = sc.nextInt();
            }
            
            // DP 테이블: dp[w]는 가방의 남은 부피가 w일 때 최대 가치
            int[] dp = new int[K + 1];
            
            // 물건을 하나씩 처리
            for (int i = 0; i < N; i++) {
                int volume = volumes[i];
                int value = values[i];
                
                // 뒤에서부터 DP 테이블 업데이트 (부피가 큰 것부터 업데이트해야 중복 선택 방지 가능)
                for (int w = K; w >= volume; w--) {
                    dp[w] = Math.max(dp[w], dp[w - volume] + value);
                }
            }
            
            // 결과 출력: dp[K]가 최대 가치
            System.out.println("#" + t + " " + dp[K]);
        }
        
        sc.close();
    }
}