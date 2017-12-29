package chapter1_1;

import java.util.*;

public class Sqrto 
{
	public static double sqrt(double c)
	{
		if (c < 0)
			return Double.NaN;
		double err=1e-15;
		double t=c;
		while (Math.abs(t - c/t) > t*err)
		{
			t=(t+c/t)/2.0;
		}
		return t;
		
	}
	
	public static void main(String[] args)
	{
		double input=0 , result=0;
		Scanner isr=new Scanner(System.in);
		System.out.println("Input a double and Output its sqrt.");
		input=isr.nextDouble();
		isr.close();
		result=sqrt(input);
		System.out.print(result);
	}
}
