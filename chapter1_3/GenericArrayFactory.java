package chapter1_3;

import java.lang.reflect.Array;

public class GenericArrayFactory<Item> 
{
	public Item[] arrayof(Class<Item[]> clazz, int length)
	{
		return clazz.cast(Array.newInstance(clazz.getComponentType(), length));
	}
	
	public static void main(String[] args)
	{
		Integer[] arr=new GenericArrayFactory<Integer>().arrayof(Integer[].class, 40);
		for(int i=0;i<40;++i)
		{
			arr[i]=i;
		}
		
	}
}
