package homework;


public class HW2 {
	public static void main(String[] args)
	{
		HW2 hw = new HW2();
		System.out.println(hw.findBadVersion(20));
	}
	
	public int findBadVersion(int n)
	{
		int lower = 1;
		int upper = n;
		if(isBadVersion(lower))
		{
			return 1;
		}
		if(!isBadVersion(upper))
		{
			return -1;
		}
		
		while(lower <= upper)
		{
			int mid = lower + (upper - lower) / 2;
			if(isBadVersion(mid))
			{
				upper = mid - 1;
			}
			else
			{
				lower = mid + 1;
			}
		}
		
		return lower;
	}
	
	public boolean isBadVersion(int version)
	{
		return version > 6;
	}
}
