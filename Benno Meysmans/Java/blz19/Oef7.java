import java.lang.*;

public class Oef7
{
	public static void main(String args[])
	{		
		int a[] = {12, 34, 56, 78, 123, 234, 99, 88};
		int b[] = new int[8];
		int hoogstegetal = 0;
	
		for(int j = 0; j < b.length; j++)
		{
			hoogstegetal = 0;
			
			for(int i = 0; i < a.length; i++)
			{

				if(a[i] > hoogstegetal)
				{
					hoogstegetal = a[i];
				}
	
				b[j] = hoogstegetal;				
			}

			for(int k = 0; k < a.length; k++)
			{
				if(a[k] == hoogstegetal)
				{
					a[k] = 0;
				}
			}
				
			System.out.println(b[j]);			
		}	
	}
}