import java.lang.*;

public class OefeningPagina19Oef3{

	public static void main(String args[])
	{
		float noemer = 1;
		float pi = 0;
		

		for(int i = 1; i <= 10000; i++)
		{
			if(i % 2 == 0)
			{
				pi -= (1/noemer);
			}

			else
			{
				pi += (1/noemer);
			}
			noemer +=2;
		}
		System.out.println(4*pi);
	}

}