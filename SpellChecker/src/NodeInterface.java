import java.util.Map;

/**
 * 
 * Node.java
 * 
 * Interface class provides a basic node structure for tree data structure.
 * 
 * @author Ankush Bansal
 * @since 08-21-2014
 */
public interface NodeInterface {
	
	/**
	 *  This method returns value stored in the node.
	 * @return char type value stored in the node
	 */
	public char getValue();
	
	/**
	 * This method sets value in the node
	 * @return true if value is properly set, else it returns false
	 */
	public boolean setValue( char value);
	
	/**
	 * This method sets true if node marks end of a word
	 * @return true if value is correctly set, else it returns false
	 */ 
	public boolean isEnd( boolean end);	
	
	/**	
	 * This method returns whether node is end of a word or not
	 * @return true if it's the end of a word, else it returns false 
	 */
	public boolean hasEnd();
	
	/**
	 * This method returns map containing information about child nodes
	 * @return
	 */
	public Map<Character, NodeInterface> getChildren();
	

}
