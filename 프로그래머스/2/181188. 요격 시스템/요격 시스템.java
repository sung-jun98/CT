

import java.util.*;
import java.io.*;

public class Solution {
	static int[][] targets;
	static Deque<int[]> deque;
	static int answer;

	public static int solution(int[][] iTargets) {
		answer = 1;
		targets = iTargets;
		deque = new ArrayDeque<>();

		// 정렬
		Arrays.sort(targets, (a, b) -> Integer.compare(a[0], b[0]));
		
		deque.add(targets[0]);
		getAnswer();
		System.out.println(answer);
		return answer;
	}
	
	private static void getAnswer() {
		int preStart = targets[0][0];
		int preEnd = targets[0][1];
		
		for(int[] target : targets) {
			int curStart = target[0];
			int curEnd = target[1];
			
			if (curStart >= preStart && curStart < preEnd) {
				preStart = Math.max(preStart, curStart);
				preEnd = Math.min(preEnd, curEnd);
				//continue;
			} else {
				answer += 1;
				//prev = target;
				preStart = target[0];
				preEnd = target[1];
			}
		}
	}

	public static void main(String[] args) throws Exception {
		solution(targets);
	}

}
