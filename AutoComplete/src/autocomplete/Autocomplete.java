package autocomplete;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Program: AutoComplete
 * Project: AssignmentAutoComplete
 * Package: autocomplete
 * @author Taizya
 * @since Oct 13, 2015
 * 
 */
public class Autocomplete {
/**
 * Array of terms
 */
	private final Term[] terms;
	/**
	 * Size of term array
	 */
	private final int N;
	/**Constructor that initializes the data structure from the given array of terms.
	 * 
	 * @param terms
	 */
    public Autocomplete(Term[] terms)
    {
    	if(terms == null) throw new IllegalArgumentException();
    	this.N = terms.length;
    	this.terms = new Term[N];
    	//make a defensive copy
    	for(int i = 0; i < N; i++)
    	this.terms[i] = terms[i];
    		   	
    }

    /**Return all terms that start with the given prefix, in descending order of weight.
     * 
     * @param prefix
     * @return array of terms that match
     */
    public Term[] allMatches(String prefix)
    {
    	if(prefix == null) throw new IllegalArgumentException();
    	
    	ArrayList<Term> temp = new ArrayList<Term>();
    	
    	for(Term x: terms)
    	{
    		if(x.contains(prefix))
    			temp.add(x);
    	}
    	int N = temp.size();
    	 Term[] matches = new Term[N];
    	if(temp != null)
    	for(int i = 0; i < N; i++ )
    	{
    		matches[i] = temp.get(i);
    	}
    	
    	Arrays.sort(matches, Term.byReverseWeightOrder());
    	return matches;
    }
    /** Returns the number of terms that start with the given prefix.
     * 
     * @param prefix
     * @return number of matches
     */
    public int numberOfMatches(String prefix)
    {
    	if(prefix == null) throw new IllegalArgumentException();
    	Arrays.sort(terms, Term.byPrefixOrder(prefix.length()));
    	int numMatch = 0;
    	for(Term x: terms)
    	{
    		if(x.contains(prefix))
    			++numMatch;
    	}

    	return numMatch;
    }
    
    
}
