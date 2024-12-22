

import java.util.*;
import java.io.*;

public class Main {
	static String input;
	static int[] dp;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		input = br.readLine();
		dp = new int[input.length() + 1];
		answer = 0;

		if (input.charAt(0) - '0' == 0) {
			System.out.println(0);
			return;
		}

		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= input.length(); i++) {
			int n1 = input.charAt(i - 1) - '0';
			int n2 = 10 * (input.charAt(i - 2) - '0') + input.charAt(i - 1) - '0';

			if(n1 != 0) {
				dp[i] = dp[i-1] % 1000000;
			}
			if (n2 >= 10 && n2 <= 26) {
				dp[i] = (dp[i] + dp[i - 2]) % 1000000;
			}
		}
		
		System.out.println(dp[input.length()]);
	}
}
