package dsa.graph;

//Floyd's Warshall algorithm Graph shortest path
//this can be used to find all the shortest path between all the vertices
//can be used for directed graph also
//negative weights as well.

public class FloydWarshallAlgorithm {
	
	 public int[][] solve(int[][] A) {
		 int n = A.length;
		 int[][] result = new int[n][n];
		 for(int i = 0;i<n;i++) {
			 for(int j = 0;j<n;j++) {
				 if(i != j) {
					 if(A[i][j] == -1) {
						 result[i][j] = Integer.MAX_VALUE;
					 } else {
						 result[i][j] = A[i][j];
					 }
				 }
					 
			 }
		 }
		 for(int k = 0;k < n;k++) {
			 for(int i = 0;i < n;i++) {
				 for(int j = 0;j < n;j++) {
					 if(result[i][k] == Integer.MAX_VALUE || result[k][j] == Integer.MAX_VALUE) {
						 result[i][j] = Math.min(result[i][j], Integer.MAX_VALUE);
					 } else {
						 result[i][j] = Math.min(result[i][j], (result[i][k]+result[k][j]));
					 }
				 }				 
			 }
		 }
		 for(int i = 0;i<n;i++) {
			 for(int j = 0;j<n;j++) {
				 if(i != j) {
					 if(result[i][j] == Integer.MAX_VALUE) {
						 result[i][j] = -1;
					 }
				 }
					 
			 }
		 }
		 return result;
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FloydWarshallAlgorithm da = new FloydWarshallAlgorithm();
		int[][] B = new int[][] {
			{0 , 50 , 39},
			{-1 , 0 , 1},
			{-1 , 10 , 0}
		};
		
		System.out.println(da.solve(B));
	}
}
