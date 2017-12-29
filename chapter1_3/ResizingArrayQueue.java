package chapter1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ResizingArrayQueue<Item> implements Iterable<Item> 
{
	private Item[] a;
	private int n;
	
	@SuppressWarnings("unchecked")
	public ResizingArrayQueue() 
	{
		a=(Item[]) new Object[2];
		n=0;
	}
	
	public boolean isEmpty()
	{
		return n==0;
	}
	
	public int size()
	{
		return n;
	}
	
	@SuppressWarnings("unchecked")
	private void resize(int capacity)
	{
		assert capacity >= n;
		
		Item[] temp=(Item[]) new Object[capacity];
		for(int i = 0; i < n; ++i)
		{
			temp[i]=a[i];
		}
		a=temp;
	}
	
	public void push(Item item)
	{
		if(n == a.length)		resize(2*a.length);
		a[n]=item;
		n++;
	}
	
	public Item pop()
	{
		if(isEmpty()) 	throw new NoSuchElementException("Stack underflow");
		Item item=a[0];
		for(int i = 0; i < n-1; ++i)
		{
			a[i]=a[i+1];
		}
		a[n-1]=null;
		n--;
		
        if (n > 0 && n == a.length/4) resize(a.length/2);
        return item;
	}
	
    public Item peek() 
    {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return a[n-1];
    }
	
    public Iterator<Item> iterator() 
    {
        return new ArrayIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ArrayIterator implements Iterator<Item> 
    {
    	private int i;
    	
    	private ArrayIterator()
    	{
    		i=0;
    	}
    	
        public boolean hasNext() {
            return i < n;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[i++];
        }
    	
    }
    
    public static void main(String[] args) 
    {
        ResizingArrayQueue<String> queue = new ResizingArrayQueue<String>();
        
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) queue.push(item);
            else if (!queue.isEmpty()) StdOut.print(queue.pop() + " ");
        }
        StdOut.println("(" + queue.size() + " left on stack)");
        
        Iterator<String> it=queue.iterator();
        while(it.hasNext())
        {
        	StdOut.println(it.next());
        }
        
    }
}
	

