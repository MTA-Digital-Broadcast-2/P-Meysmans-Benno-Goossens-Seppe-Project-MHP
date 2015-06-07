import java.lang.*;

public class OefeningPagina19Oef5{

	public static void main(String args[])
	{
		boolean ispriemgetal;

		for(int a = 3; a < 100; a++)
		{
			ispriemgetal = true;

			for(int b = 1; b < a-1; b++)
			{
				if(a % b ==0 && b != 1 && b !=1)
				{
					ispriemgetal = false;
				}
			}

			if(ispriemgetal)
			{
				System.out.println(a);
			}
		}
	}

}