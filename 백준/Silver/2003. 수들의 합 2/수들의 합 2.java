
import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int answer;
	static int[] inputs;
	static int left, right;
	static int sum;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		inputs = new int[N];
		answer = 0;
		left = 0;
		right = 0;
		sum = 0;
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			 inputs[i] = Integer.parseInt(st.nextToken());
			 
		}
		
		/*
		 * 슬라이싱 윈도우 알고리즘 : 
		 * 1. 부분배열의 합이 Target의 값보다 크거나 같으면 Left = Left + 1을 해준다.
		 * 2. 부분배열의 합이 Target의 값보다 같거나 작으면 Right = Right + 1을 해준다.
		 * 3. 부분배열의 합이 Target의 값과 같다면 결과값을 +1 해준다.
		 * 
		 */
		while(true) {
			if(sum >= M) {
				sum -= inputs[left++];
			}
			else if(right == N) {
				break;
			}
			else if(sum < M) {
				sum += inputs[right++];
			}
			
			
			if(sum == M) {
				answer += 1;
			}
		}
	
		System.out.println(answer);
	}

}
