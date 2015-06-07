import java.lang.*;

public class OefeningPagina19Oef2{

	public static void main(String args[])
	{
		String[] dagen = {"zondag", "maandag", "dinsdag", "woensdag", "donderdag", "vrijdag", "zaterdag"};
		int b = -1;

		for(int a = 1; a < 29; a++)
		{
			if(b > 5)
			{
				b = -1;
			}
			b++;
			

			System.out.println(dagen[b] + " " + a + " februari");
		}
	}

}