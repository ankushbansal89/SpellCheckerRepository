
/**
 * 
 * SpellCheckerInterface.java
 * 
 * SpellCheckerInterface provides a spell checker functionality.
 * 
 * @author Ankush Bansal
 * @since 08-21-2014
 */

public interface SpellCheckerInterface {

	/**
	 * This method reads the text file containing correct words and insert it into the trie.
	 * @param trie, filename
	 */
	public TrieInterface readDictionary( TrieInterface trie, String filename);
	
	/**
	 * This method creates trie structure
	 * @return newly created trie structure
	 */
	public TrieInterface createTrie();
	
	/**
	 * This method reads the document and check whether words are correctly spelled or not
	 * @param trie
	 */
	public void analyseText( TrieInterface trie, String filename );
}
