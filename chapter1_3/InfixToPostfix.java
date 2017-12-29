package chapter1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class InfixToPostfix 
{
	public static void main(String[] args)
	{
		String s=StdIn.readAll();
		Stack<Character> stack=new Stack<Character>();
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)==' ')	continue;
			else if(s.charAt(i)=='(')	StdOut.print("");
			else if(s.charAt(i)==')')	StdOut.print(stack.pop()+" ");
			else if(s.charAt(i)=='*')	stack.push(s.charAt(i));
			else if(s.charAt(i)=='+')	stack.push(s.charAt(i));
			else	StdOut.print(s.charAt(i)+" ");
		}
	}
}
