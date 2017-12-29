package chapter1_2;

import edu.princeton.cs.algs4.StdOut;

public class Rational 
{
	private long numerator;
	private long denominator;
	
	public long EuclidianAlgorithm(long m, long n) // m and n
	{
		if (m<0) m=-m;
		if (n<0) n=-n;
		if (m==0)	return n;
		while (n!=0)
		{
			long temp= n;
			n = m % n;
			m = temp;
		}
		return m;
	}
	
	public long LCM(long m, long n)
	{
		if (m<0) m=-m;
		if (n<0) n=-n;
		return m*n/EuclidianAlgorithm(m,n);
	}
	
	
	public Rational(long numerator, long denominator)
	{
		if (denominator == 0) throw new IllegalArgumentException("Denominator cannot be zero!");
		long gcd=EuclidianAlgorithm(numerator,denominator);
		this.numerator=numerator/gcd;
		this.denominator=denominator/gcd;
		if (this.denominator<0)
		{
			this.denominator=-this.denominator;
			this.numerator=-this.numerator;
		}
	}
	
	public long numerator() 
	{
		return numerator;
	}
	
	public long denominator()
	{
		return denominator;
	}
	
	
	public Rational plus(Rational b) // a+b=c
	{
		long lcm=this.denominator*b.denominator;
		long numerator=this.numerator*b.denominator+b.numerator*this.denominator;
		Rational c=new Rational(numerator,lcm);
		return c;			
	}
	
	public Rational minus(Rational b) // a-b=c
	{
		long lcm=this.denominator*b.denominator;
		long numerator=this.numerator*b.denominator-b.numerator*this.denominator;
		Rational c=new Rational(numerator,lcm);
		return c;			
	}
	
	public Rational times(Rational b) // a*b=c
	{
		Rational c=new Rational(this.numerator*b.numerator, this.denominator*b.denominator);
		return c;
	}
	
	public Rational divides(Rational b) // a/b=c
	{
		Rational c=new Rational(this.numerator*b.denominator, this.denominator*b.numerator);
		return c;
	}
	
    public int compareTo(Rational that) {
        long lhs = this.numerator * that.denominator;
        long rhs = this.denominator * that.numerator;
        if (lhs < rhs) return -1;
        if (lhs > rhs) return +1;
        return 0;
    }
    
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        Rational that = (Rational) other;
        return this.compareTo(that) == 0;
    }

	
	public String toString()
	{
		if (this.denominator==1) 
			return this.numerator+"";
		else 	
			return numerator+"/"+denominator;
	}
	
    public static void main(String[] args) {
        Rational x, y, z;

        // 1/2 + 1/3 = 5/6
        x = new Rational(1, 2);
        y = new Rational(1, 3);
        z = x.plus(y);
        StdOut.println(z);

        // 8/9 + 1/9 = 1
        x = new Rational(8, 9);
        y = new Rational(1, 9);
        z = x.plus(y);
        StdOut.println(z);

        // 1/200000000 + 1/300000000 = 1/120000000
        x = new Rational(1, 200000000);
        y = new Rational(1, 300000000);
        z = x.plus(y);
        StdOut.println(z);

        // 1073741789/20 + 1073741789/30 = 1073741789/12
        x = new Rational(1073741789, 20);
        y = new Rational(1073741789, 30);
        z = x.plus(y);
        StdOut.println(z);

        //  4/17 * 17/4 = 1
        x = new Rational(4, 17);
        y = new Rational(17, 4);
        z = x.times(y);
        StdOut.println(z);

        // 3037141/3247033 * 3037547/3246599 = 841/961 
        x = new Rational(3037141, 3247033);
        y = new Rational(3037547, 3246599);
        z = x.times(y);
        StdOut.println(z);

        // 1/6 - -4/-8 = -1/3
        x = new Rational(1, 6);
        y = new Rational(-4, -8);
        z = x.minus(y);
        StdOut.println(z);
    }
}
