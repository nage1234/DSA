package dsa.dp;

//complexity - time and space complexity are O(N)

public class MaxProductSubarray {
	 private int[] recursiveMaxProduct(int[] A, int[] result, int i, int j) {
		 if (i >= A.length) {
			 j++;
			 i=j;
			 result[A.length+1] = Math.max(result[A.length], result[A.length+1]);
			 result[A.length] = 1;
			 if (j < A.length) {
			 } else {
				 return result;
			 }
		 }
		 result[A.length] = Math.max(result[A.length], result[A.length] * A[i]);
		 return recursiveMaxProduct(A, result, i+1, j);
	 }
	   

	public static void main(String[] args) {
		int[] A = new int[] {4, 2, 5, -1};
		int n = A.length;
		int[] finalProd = new int[n+2];
		finalProd[n] = 1;
		MaxProductSubarray max = new MaxProductSubarray();
        int[] result = max.recursiveMaxProduct(A, finalProd, 0, 0);
        System.out.println(result[A.length+1]);
	}

}
