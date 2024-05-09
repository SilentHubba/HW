package homework;

public class HW8 {
    public int longestPalindrome(String s) {
    	int[] charCount = new int[58];
    	for(int i = 0; i < s.length(); i++)
    	{
    		charCount[s.charAt(i) - 65]++;
    	}
    	
    	int length = 0;
    	boolean isAnOdd = false;
    	for(int count: charCount)
    	{
    		if(count > 0)
    		{
    			if(count % 2 == 1)
    			{
    				length += count - 1;
    				isAnOdd = true;
    			}
    			else
    			{
    				length += count;
    			}
    		}
    	}
    	
    	if(isAnOdd)
    	{
    		length += 1;
    	}
    	
    	return length;
    }
    
    public static void main(String[] args)
    {
    	HW8 test = new HW8();
    	System.out.println(test.longestPalindrome("abccccdd"));
    	System.out.println(test.longestPalindrome("speediskey"));
    	System.out.println(test.longestPalindrome("tejaszA"));

    }
}
