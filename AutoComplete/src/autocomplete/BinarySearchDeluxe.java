package autocomplete;

import java.util.Comparator;

/**
 * Program: BinarySearchDeluxe
 * Project: AssignmentAutoComplete
 * Package: autocomplete
 * @author Taizya
 * @since Oct 13, 2015
 * 
 */
public class BinarySearchDeluxe {

	/** Returns the index of the first key in a[] that equals the search key, or -1 if no such key.
	 * 
	 * @param a Array being searched
	 * @param key key that is being searched for
	 * @param comparator compares values through the search
	 * @return first index of key
	 */
	public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator)
	{
		
		int hi = a.length - 1;
		int lo = 0;
		while(lo < hi){
		int mid = lo + (hi - lo)/2;
		if(comparator.compare(key, a[mid]) < 0)
			hi = mid - 1;
		else if(comparator.compare(key, a[mid]) > 0)
			lo = mid + 1;
		else 
			while(mid > 0)
				{
					if(a[mid-1] == key)
						mid = mid -1;
					else 
						return mid;
				}
			
		}
		
		return -1;
	}
	
	 /** Return the index of the last key in a[] that equals the search key, or -1 if no such key
	  * 
	  *@param a Array being searched
	 * @param key key that is being searched for
	 * @param comparator compares values through the search
	 * @return last index of key 
	  */
	public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator)
	{
		int hi = a.length - 1;
		int lo = 0;
		while(lo < hi){
		int mid = lo + (hi - lo)/2;
		if(comparator.compare(key, a[mid]) < 0)
			hi = mid - 1;
		else if(comparator.compare(key, a[mid]) > 0)
			lo = mid + 1;
		else 
			while(mid < a.length -1)
				{
					if(a[mid+1] == key)
						mid = mid + 1;
					else
						return mid;
				}
		}
		
		return -1;
		
	}
	
	
}
