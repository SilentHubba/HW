package homework;

public class HW1 {
	public boolean isPalindrome(String input)
	{
		input = input.replaceAll("[^A-Za-z0-9]","");
		input = input.toLowerCase();
		int halfLength = input.length() / 2;
		
		for(int i = 0; i < halfLength; i++)
		{
			if(input.charAt(i) != input.charAt(input.length() - i - 1))
			{
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args)
	{
		HW1 tester = new HW1();
		System.out.println(tester.isPalindrome("Farigiraf-=-="));
	}
}
