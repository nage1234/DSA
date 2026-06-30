package dsa.dp;

//complexity - time and space complexity are O(N)

public class MaxProductSubarray {
	 private int recursiveMaxProduct(int[] A) {
		int n = A.length;
       int maxProd = A[0];
       int minProd = A[0];
       int result = A[0];
       for (int i = 1;i <n; i++) {
           int tempMax = Math.max(A[i], Math.max(A[i] * maxProd, A[i] * minProd));
           int tempMin = Math.min(A[i], Math.min(A[i] * maxProd, A[i] * minProd));
           maxProd = tempMax;
           minProd = tempMin;
           result = Math.max(result, maxProd);
       }
       return result;
	 }
	   
	public static void main(String[] args) {
		int[] A = new int[] {2, 4, -3, 8};
		MaxProductSubarray mmax = new MaxProductSubarray();
		int result = mmax.recursiveMaxProduct(A);
		System.out.println(result);
	}
}
