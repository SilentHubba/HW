package homework;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HW7 {
	public int minMeetingRooms(int[][] intervals) 
	{  
		// Sort the intervals by start time 
		Arrays.sort(intervals, Comparator.comparingDouble(o -> o[0]));
		
		// Make a heap of end times. 
		PriorityQueue<Integer> endTimeHeap = new PriorityQueue<>();
		int roomCount = 0;
		
		// We want to check if the earliest end time in an existing room ends
		// earlier than the start time we want to add
		for(int i = 0; i < intervals.length; i++)
		{
			endTimeHeap.add(intervals[i][1]);
			if(endTimeHeap.peek() <= intervals[i][0])
			{
				// The interval can be fit into an existing room.
				endTimeHeap.poll();
			}
			else
			{
				// The interval cannot be fit into an existing room
				roomCount++;
			}
		}
		
		return roomCount;
	}
	
	public static void main(String[] args)
	{
		HW7 tester = new HW7();
		int[][] arr1 = {{0, 30}, {5, 10}, {15, 20}};
		System.out.println(tester.minMeetingRooms(arr1));
		
		int[][] arr2 = {{0, 1}, {1, 2}, {2, 3}};
		System.out.println(tester.minMeetingRooms(arr2));
		
		int[][] arr3 = {{0, 5}, {10, 15}, {0, 10}, {5, 15}};
		System.out.println(tester.minMeetingRooms(arr3));


	}
}
