import java.lang.*;

public class OefeningPagina19Oef6{

	public static void main(String args[])
	{
		int a[] = {12, 34, 56, 78, 123, 234, 99, 88};
		int b = 1;

		for(int i = 0; i < 8; i++)
		{
			if(a[i] > b)
			{
				b = a[i];
			}
		}
		System.out.println(b);
	}

}