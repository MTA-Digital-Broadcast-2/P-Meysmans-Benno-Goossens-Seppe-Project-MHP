import java.lang.*;

public class Oef5
{
	public static void main(String args[])
	{		
		boolean ispriemgetal;
		
		for(int i = 3; i < 100; i++)
		{		
			ispriemgetal = true;
			
			for(int j = 1; j <= i; j++)
			{
				if(i % j == 0 && j != 1 && j != i)
				{
					ispriemgetal = false;
				}			
			}

			if(ispriemgetal)
			{
				System.out.println(i);
			}
		}
	}
}