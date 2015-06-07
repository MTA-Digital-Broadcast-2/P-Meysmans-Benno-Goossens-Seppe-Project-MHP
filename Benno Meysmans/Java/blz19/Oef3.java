import java.lang.*;

public class Oef3
{
	public static void main(String args[])
	{				
		float pi;
		float tussendehaakjes = 0;
		float j = 1;

		for(int i = 1; i <= 10000; i++)
		{
			if(i % 2 == 0)
			{
				tussendehaakjes-= 1/j;			
			}

			else
			{
				tussendehaakjes+= 1/j;				
			}

			j+=2;
		}
		
		pi = 4*tussendehaakjes;
		System.out.println(pi);
	}
}