package dsa.tree;

import java.util.ArrayList;
import java.util.PriorityQueue;
import dsa.common.Edge;
public class DijkstraAlgorithm {	
	public int solve(int A, int[][] B, int C, int D) {		
		int n = B.length;
		//maintain this queue for min neighbours
		PriorityQueue<Edge> minHeap = new PriorityQueue<>((Edge o1, Edge o2) -> o1.W - o2.W);
		//declare Adjacency list
		ArrayList<ArrayList<Edge>> adjList = new ArrayList<>();
		for(int i=0;i<A;i++) {
			adjList.add(new ArrayList<>());
		}
		//construct Adj list
		//undirected graph, so both ways to be added
		for(int i = 0;i<n;i++) {
			Edge e1 = new Edge(B[i][1],B[i][2]);
			Edge e2 = new Edge(B[i][0],B[i][2]);		        
        	adjList.get(B[i][0]).add(e1);
            adjList.get(B[i][1]).add(e2);            
		}
		int[] visited = new int[A];
		minHeap.add(new Edge(C, 0));
		int[] minDist = new int[A];
		int distance = dijkstra(minHeap, adjList, C, D, visited, minDist);
		return distance == 0 ? -1 : distance;
    }
	
	public int dijkstra(PriorityQueue<Edge> minHeap, ArrayList<ArrayList<Edge>> adjList, int source, int dest, int[] visited, int[] minDist) {
		while(minHeap.size() > 0) {
			Edge e = minHeap.poll();
			int vert = e.V;
			int weit = e.W;
			minDist[vert] = minDist[vert] == 0 ? weit : Math.min(minDist[vert], weit);
			ArrayList<Edge> list = adjList.get(vert);
			visited[vert] = 1;
			for(Edge neighbour: list) {
				if(visited[neighbour.V] == 0) {
					Edge e2 = new Edge(neighbour.V, neighbour.W+weit);
					minHeap.add(e2);
				}
			}
		}
		return minDist[dest];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DijkstraAlgorithm da = new DijkstraAlgorithm();
		System.out.println(da.solve(6, new int[][]{{2, 5, 1},{1, 3, 1},{0, 5, 2},{0, 2, 2},{1, 4, 1},{0, 1, 1}}, 3, 2));
	}

}
