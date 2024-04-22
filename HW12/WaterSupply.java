package nodes;
import java.util.PriorityQueue;

public class WaterSupply {
	public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
		// The 0th node is the node that is building a well
		int[][] nodes = new int[n+1][n+1];
		
		for(int i = 0; i < n + 1; i++)
		{
			for(int j = 0; j < n + 1; j++)
			{
				nodes[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for(int i = 1; i < n + 1; i++)
		{
			nodes[0][i] = wells[i - 1];
			nodes[i][0] = wells[i - 1];
		}
		
		for(int i = 0; i < pipes.length; i++)
		{
			if(nodes[pipes[i][0]][pipes[i][1]] > pipes[i][2])
			{
				nodes[pipes[i][0]][pipes[i][1]] = pipes[i][2];
				nodes[pipes[i][1]][pipes[i][0]] = pipes[i][2];
			}
		}
		
		int[] visited = new int[n+1];
		int visitedNodes = 1;
		visited[0] = 1;
		// Min heap that compares based on the first element in the arrays
		PriorityQueue<int[]> edgeHeap = new PriorityQueue<int[]>(n + 1, (a,b) -> Integer.compare(a[0],b[0]));
		for(int i = 1; i < n + 1; i++)
		{
			// Edges have {weight, potentially undiscovered node (the node that is not currently being visited)}
			int[] edge = {nodes[0][i], i};
			edgeHeap.add(edge);
		}
		
		int finalCost = 0;
		// Loop through edges and add costs until all nodes have been found
		while(visitedNodes < n + 1)
		{
			int[] currentEdge = edgeHeap.remove();
			if(visited[currentEdge[1]] == 0)
			{
				visited[currentEdge[1]] = 1;
				visitedNodes++;
				finalCost += currentEdge[0];
				
				// Add all edges from the new house
				for(int i = 1; i < n + 1; i++)
				{
					if(nodes[currentEdge[1]][i] < Integer.MAX_VALUE)
					{
						int[] newEdge = {nodes[currentEdge[1]][i], i};
						edgeHeap.add(newEdge);
					}
				}
			}
		}
		
		return finalCost;
	}
	
	public static void main(String[] args)
	{
		int n = 2;
		int[] wells = {1, 1};
		int[][] pipes = {{1, 2, 1},{1, 2, 2}};
		WaterSupply waterSupply = new WaterSupply();
		int cost = waterSupply.minCostToSupplyWater(n, wells, pipes);
		System.out.println(cost);
		
		int wells2[] = {1, 1, 4, 10, 10};
		int[][] pipes2 = {{1, 2, 1}, {1, 2, 2}, {1, 3, 2}, {3, 4, 5}, {5, 4, 4}};
		cost = waterSupply.minCostToSupplyWater(5, wells2, pipes2);
		System.out.println(cost);
		
		int wells3[] = {2};
		int[][] pipes3 = {};
		cost = waterSupply.minCostToSupplyWater(1, wells3, pipes3);
		System.out.println(cost);
	}
}
