package images;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FillImage {
	public int[][] floodFill(int[][] image, int sr, int sc, int color) {
		// Case to save time if there is no pixel to change
		if(image[sr][sc] == color)
		{
			return image;
		}
		
		// Initialize variables
		Queue<int[]> neighborQueue = new LinkedList<>();
		int[] start = {sr, sc};
		neighborQueue.add(start);
		ArrayList<int[]> visited = new ArrayList<>();
		visited.add(start);
		int startPointColor = image[sr][sc];
		int rowLength = image.length;
		int colLength = image[sr].length;
		ArrayList<int[]> directions = new ArrayList<>();
		int[] up = {0, -1};
		int[] down = {0, 1};
		int[] left = {-1, 0};
		int[] right = {1, 0};
		directions.add(up);
		directions.add(down);
		directions.add(left);
		directions.add(right);
		
		// Loop until the queue is empty
		while(!neighborQueue.isEmpty())
		{
			// Get the first element of the queue
			int[] currentPixel = neighborQueue.remove();
			
			// Change the color of the pixel
			image[currentPixel[0]][currentPixel[1]] = color;
			
			// Check all four directions
			for(int i = 0; i < 4; i++)
			{
				// Create the array for the neighboring pixel coordinates
				int[] neighborPixel = currentPixel.clone();
				neighborPixel[0] += directions.get(i)[0];
				neighborPixel[1] += directions.get(i)[1];
				
				// Check that the neighboring pixel is not out of bounds, has the color we want
				// to replace, and hasn't been visited already. If these are all true, add it to
				// the queue and visited arraylist
				if(neighborPixel[0] >= 0 && neighborPixel[0] < rowLength &&
				   neighborPixel[1] >= 0 && neighborPixel[1] < colLength &&
				   image[neighborPixel[0]][neighborPixel[1]] == startPointColor &&
				   !visited.contains(neighborPixel))
				{
					visited.add(neighborPixel);
					neighborQueue.add(neighborPixel);
				}
			}
		}
		
		return image;
	}
	
	public static void main(String[] args)
	{
		
		int[][] image1 = {{1,1,1},
						  {1,1,0},
						  {1,0,1}};
						  
		//int[][] image1 = {{0, 0, 0},{0, 0, 0}};
		int sr = 1;
		int sc = 1;
		int color = 2;
		FillImage imageFiller = new FillImage();
		imageFiller.floodFill(image1, sr, sc, color);
		
		for(int i = 0; i < image1.length; i++)
		{
			for(int j = 0; j < image1[0].length; j++)
			{
				System.out.print(image1[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
