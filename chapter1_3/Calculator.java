package chapter1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Calculator 
{
	public Calculator()
	{
	}
	
	public String InfixToPostfix(String s)
	{
		StringBuilder ans=new StringBuilder();
		Stack<Character> stack=new Stack<Character>();
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)==' ')	continue;
			else if(s.charAt(i)=='(')	ans.append("");
			else if(s.charAt(i)==')')	ans.append(stack.pop()+"");
			else if(s.charAt(i)=='*')	stack.push(s.charAt(i));
			else if(s.charAt(i)=='+')	stack.push(s.charAt(i));
			else	ans.append(s.charAt(i)+"");
		}
		return ans.toString();
	}
	
	public double Evaluate(String str)
	{	
   	 	 Stack<Double> stack=new Stack<Double>();
	     for(int i=0;i<str.length();++i)
	     {

	    	 char c=str.charAt(i);
	    	 String s=c+"";
	         if      (s.equals("+")) stack.push(stack.pop() + stack.pop());
	         else if (s.equals("*")) stack.push(stack.pop() * stack.pop());
	         else stack.push(Double.parseDouble(s));
	     }
	     return stack.pop();
	}
	
	public static void main(String[] args)
	{
		String inp="( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )";
		Calculator cal=new Calculator();
		StdOut.print(cal.InfixToPostfix(inp));
		StdOut.println();
		StdOut.print(cal.Evaluate(cal.InfixToPostfix(inp)));
	}
}
