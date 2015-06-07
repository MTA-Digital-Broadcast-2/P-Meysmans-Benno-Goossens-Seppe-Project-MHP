import java.lang.*;

public class OefeningPagina19Oef7{

	public static void main(String args[])
	{
		int a[] = {12, 34, 56, 78, 123, 234, 99, 88};
		int b[] = {0, 0, 0, 0, 0, 0, 0, 0};
		int c = 0;
		int d = 0;

		for(int j = 0; j < 8; j++)
		{
			for(int i = 0; i < 8; i++)
			{
				if(a[i] > c)
				{
					c = a[i];
					d = i;
				}
			}
			b[j] = c;
			a[d] = 0;
			c = 0;
		}
		
		for(int i = 0; i < 8; i++)
		{
			System.out.println(b[i]);
		}
	}

}