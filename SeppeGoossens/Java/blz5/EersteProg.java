/**
 * Deze klasse is een java programa
 * @author Seppe Goossens
 * @version 1.5
 */

import java.lang.*;

public class EersteProg{


/**
 * Deze methode is de main methode
 * @param args Dit zijn de command line parameters
 */

	
	public static void main(String args[])
	{

		char c;		//16 bits UNICODE ipv ASCII in C
		c='E';
		
		c++;		//Wordt opgeslagen als een getal, dus dit kan, en zal F als resultaat hebben

		System.out.println("c= "+c);		



		int a;		//32 bits signed getal
		byte b;		//8 bits signed getal
		short s;	//16 bits
		long l;		//64 bits signed getal

		float f;	//32 bits
		double d;	//64 bits

		a=5;
		a=a+1;
		f=3.3f;		//f erachter zette zodat ge geen problemen krijgt
		f=f+0.1f;

		System.out.print("a="+a+" f="+f);

		boolean x= (a>5);
		System.out.println(x);

		System.out.println("Dit is mijn eerste java programma.");
		System.out.println("Dit is een " + "test " + args[0]);
	}

}