import java.util.Map;

/**
 * 
 * TrieImplementation.java
 * 
 * This class implements Trie interface and provide definition to add and contain functionality.
 */

/**
 * @author Ankush Bansal
 * @since 08-21-2014
 *
 */
public class Trie implements TrieInterface {

	// Stores information about the root node of the trie
	private NodeInterface root;
	
	/**
	 * This constructor initializes root node with value '0'
	 */
	Trie() {
		this.root = new Node('0');
	}
	
	/**
	 * @return the root
	 */
	public NodeInterface getRoot() {
		return root;
	}

	/* (non-Javadoc)
	 * @see Trie#add(java.lang.String)
	 */
	@Override
	public boolean add(String value) {
		if ( value != null ) {
			// all the characters stored in the trie are in lower case
			value = value.toLowerCase();
			int length = value.length();

			if ( length <= 0 ) {
				return false;
			}
			// Storing root node in the temporary variable
			NodeInterface node = this.root;

			// Adding ith  letter as child node of the i-1 th letter 
			for ( int i = 0; i < length; i++ ) {
				Map< Character, NodeInterface > child = node.getChildren();
				char ch = value.charAt(i);
				if ( child.containsKey(ch) ){
					node = child.get(ch);
				}else {
					// Create a new node and insert it into the children map 
					NodeInterface temp = new Node(ch);
					child.put(ch, temp);
					node = temp;
				}
			}
			// Mark the end of a word
			node.isEnd(true);
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see Trie#contains(java.lang.String)
	 */
	@Override
	public boolean contains(String value) {
		if ( value != null ) {
			
			// Convert string to lower case
			value = value.toLowerCase();
			
			int length = value.length();
			
			if ( length <= 0 ) {
				return false;
			}
			
			NodeInterface node = this.root;
			
			for ( int i = 0; i < length; i++ ) {
				char ch = value.charAt(i);
				Map< Character, NodeInterface> child = node.getChildren();
				// checking whether map contains that key or not
				if ( child.containsKey(ch) ) {
					node = child.get(ch);
					// check whether node is end of a word and it's the last character of the word
					if ( node.hasEnd() && i == ( length - 1 ) ) {
						return true;
					}
				}else {
					return false;
				}
			}
			if ( node.hasEnd() ) {
				return true;
			}
			return false;
		}
		return false;
	}
}
