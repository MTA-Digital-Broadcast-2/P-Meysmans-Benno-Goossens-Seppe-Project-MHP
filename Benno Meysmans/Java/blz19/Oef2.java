import java.lang.*;

public class Oef2
{
	public static void main(String args[])
	{
		String maand = "februari";
		String dag = "";		

		for(int i = 1; i < 29; i++)
		{
			if(i % 1 == 0)
			{
				dag = "zondag";	
			}
		

			if(i % 2 == 0)
			{
				dag = "maandag";
			}


			if(i % 3 == 0)
			{
				dag = "dinsdag";	
			}


			if(i % 4 == 0)
			{
				dag = "woensdag";	
			}


			if(i % 5 == 0)
			{
				dag = "donderdag";	
			}


			if(i % 6 == 0)
			{
				dag = "vrijdag";	
			}


			if(i % 7 == 0)
			{
				dag = "zaterdag";	
			}

			System.out.println(dag + " " + i + " " + maand); 
		}
	}
}