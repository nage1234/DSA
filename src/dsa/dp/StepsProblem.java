package dsa.dp;

//n number steps, one can either step 1 or step 2. if there are n steps, how many possible ways
//that a person can reach top. using DP

public class StepsProblem {
	
	private int getNoOfSteps(int ans[], int n) {
		if (n <= 1) {
			return 1;
		}
		else if(ans[n] > 0) return ans[n];
        ans[n] = (getNoOfSteps(ans, n-1) + getNoOfSteps(ans, n-2))%1000000007;
        return ans[n];
	}

	public static void main(String[] args) {
		int n = 8;
		StepsProblem sp = new StepsProblem();
		System.out.println(sp.getNoOfSteps(new int[n+1], n));
	}
}
