import java.lang.*;

/**
 * Deze klasse is een java programma.
 * @author Benno Meysmans
 * @version 1.0
*/


public class EersteProg
{

/**
 * Deze methode is de main method.
 * @param args Dit zijn de command line paramters
 */

	public static void main(String args[])
	{
		int a; //32 bits signed getal
		byte b; //8 bits signed getal
		short c; //16 bits signed getal
		long d; //64 bits signed getal
		float e; //32 bits komma
		double d; //64 bits komma
	
		System.out.println("Dit is mijn eerste java programma.");
		
		for(int i = 0; i < args.length; i++)
		{
			System.out.println("Dit is een " + "test " + args[i]);
		}
	}
}