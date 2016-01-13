package autocomplete;

import java.util.Comparator;

/**
 * Program: Term
 * Project: AssignmentAutoComplete
 * Package: autocomplete
 * @author Taizya
 * @since Oct 13, 2015
 * 
 * 
 * Class term is a data type that takes in a string and a weight as parameters
 */
public class Term implements Comparable<Term> {
	/**
	 * String portion of the term, immutable
	 */
	private final String query;
	/**
	 * Weight portion of the term, immutable
	 */
	private final double weight;
	
	/**
	 * Initializes a term with the given query string and weight.
	 * @param query
	 * @param weight
	 */
	public Term(String query, double weight)
	{
		if(query == null && weight < 0) 
			{
				throw new NullPointerException();
			}
		this.query = query;
		this.weight = weight;
		
	}
	/** Compare the terms in descending order by weight.
	 * 
	 * @return comparator
	 */
	public static Comparator<Term> byReverseWeightOrder()
	{
		
		Comparator<Term> byReverseWeightOrder = new Comparator<Term>()
				{

					@Override
					public int compare(Term v, Term w) {
						
						return (int) (v.weight - w.weight); 
					}
			
				};
		return byReverseWeightOrder;
		
	}
	 /**Compares the terms in lexicographic order but using only the first r characters of each query.
	  * 
	  * @param r number of characters in the prefix
	  * @return comparator
	  */
	public static Comparator<Term> byPrefixOrder(int r)
	{
		if(r < 0) throw new IllegalArgumentException();
	   Comparator<Term> byPrefixOrder = new Comparator<Term>()
	     {

			@Override
			public int compare(Term v, Term w) {
			return	v.query.substring(0,r).compareTo(w.query.substring(0, r));
				
			}
	    	 
	     };
	     
	     return byPrefixOrder;
	}
	 /** Compares the terms in lexicographic order by query.
	  * 
	  */
	@Override
	public int compareTo(Term that) {
		
		return this.query.compareTo(that.query);
	}
	/** Returns a string representation of the term 
     * 
     */
	@Override
	public String toString()
	{
		return this.weight + "\t" + this.query;
	}
	/**
	 * Finds if a term contains a given prefix
	 * @param prefix
	 * @return true if term contains prefix
	 */
	public boolean contains(String prefix) {
		
		return this.query.startsWith(prefix);
			
		
	}

}
