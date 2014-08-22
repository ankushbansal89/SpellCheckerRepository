/**
 * 
 * Trie.java
 * 
 * Interface class provides a basic functionality like add and contains for the trie data structure which is an inverted tree.
 * 
 * 
 * @author Ankush Bansal
 * @since 08-21-2014
 */

public interface TrieInterface {
	
	/**
	 * This method adds a string in the trie data structure
	 * @param String to added in the trie
	 * @return true if string is successfully added
	 */
	public boolean add( String value );
	
	/**
	 * This method searches whether a word is present in the trie or not
	 * @param String to be matched
	 * @return true if string is present in the trie, else returns false
	 */
	public boolean contains( String value );

}
