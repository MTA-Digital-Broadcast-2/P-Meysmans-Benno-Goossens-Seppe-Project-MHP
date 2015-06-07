/**
 * @Author Seppe Goossens
 * @version 1.0
 * @Deze klasse telt op tot het ingevoerde getal.
 */

import java.lang.*;

public class OefeningCommentaar{

/**
 * Dit is een ongelogelijk interessante methode.
 * @param args Dit is een array van strings waarmee parameters kunnen meegegeven worden vanaf de commandline.
 */

	public static void main(String args[])
	{
		drukaf(100);
	}

	private static void drukaf(int m)
	{
		int a;
		for(a=0; a<m; a++)
		{
			System.out.println(a);
		}
	}

}