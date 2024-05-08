package homework;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HW6 {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> sums = new ArrayList<>();
		
		// Loop through all pairs
		for(int i = 0; i < nums.length; i++)
		{
			for(int j = i + 1; j < nums.length; j++)
			{
				// Binary search for the third number
				int answer = -(nums[i] + nums[j]); 
				int lower = 0;
				int upper = nums.length - 1;
				int mid = lower + (upper - lower) / 2;
				while(lower <= upper)
				{
					mid = lower + (upper - lower) / 2;
					if(nums[mid] == answer)
					{
						// If found, make sure it's not in the solution set before adding
						if(!(mid == i || mid == j))
						{
							ArrayList<Integer> triplet = new ArrayList<>();
							triplet.add(nums[i]);
							triplet.add(nums[j]);
							triplet.add(nums[mid]);
							Collections.sort(triplet);
							boolean exists = false;
							// Check if the triplet is already in the solution
							for(int k = 0; k < sums.size(); k++)
							{
								if(triplet.get(0) == sums.get(k).get(0) &&
								   triplet.get(1) == sums.get(k).get(1) &&
								   triplet.get(2) == sums.get(k).get(2))
								{
									exists = true;
								}
							}
							
							if(!exists)
							{
								sums.add(triplet);
							}
						}
						break;
					}
					else if(nums[mid] < answer)
					{
						lower = mid + 1;
					}
					else
					{
						upper = mid - 1;
					}
				}
			}
		}
		
		return sums;

    }
	
	public static void main(String[] args)
	{
		HW6 test = new HW6();
		int[] arr1 = {-5, 0, 5, 10, -10, 0};
		System.out.println(test.threeSum(arr1));
		
		int[] arr2 = {0, 1, 1};
		System.out.println(test.threeSum(arr2));
	}
}
