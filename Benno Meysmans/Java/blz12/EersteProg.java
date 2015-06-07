import java.lang.*;

/**
 * @author Benno Meysmans
 * @version 1.0
 * Deze klasse is een oefening op javadoc
 */
public class EersteProg
{	
	/**
	 * De main method, deze wordt als eerste uitgevoerd.
      	 */	
	public static void main(String args[])
	{
	
		drukaf(100);
	}

	/**
   	 * Deze methode drukt een toenemend getal af afhankelijk van de parameter m
         */
	public static void drukaf(int m)
	{
		int a;
		for(a = 0; a < m; a++)
		{
			System.out.println(a);
		}
	}
}