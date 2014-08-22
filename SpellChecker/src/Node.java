import java.util.HashMap;
import java.util.Map;

/**
 * This class implements Node interface and provide basic functionality for the Trie Node.
 */

/**
 * @author Ankush Bansal
 * @since 08-21-2014
 *
 */
public class Node implements NodeInterface {

	// Store value of the node
	private char value;
	
	// Store whether node is end of word or not
	private boolean end;
	
	// Store details about all the child nodes of the current node
	private Map<Character, NodeInterface> children;
	
	Node( char value) {
		this.value = value;
		this.end = false;
		children = new HashMap<Character, NodeInterface> ();
	}
	
	/* (non-Javadoc)
	 * @see Node#getValue()
	 */
	@Override
	public char getValue() {
		return this.value;
	}

	/* (non-Javadoc)
	 * @see Node#setValue()
	 */
	@Override
	public boolean setValue( char value ) {
		this.value = value;
		return true;
	}

	/* (non-Javadoc)
	 * @see Node#isEnd()
	 */
	@Override
	public boolean isEnd( boolean end) {
		this.end = end;
		return true;
	}

	/* (non-Javadoc)
	 * @see Node#hasEnd()
	 */
	@Override
	public boolean hasEnd() {
		return this.end;
	}

	/* (non-Javadoc)
	 * @see Node#getChildren()
	 */
	@Override
	public Map<Character, NodeInterface> getChildren() {
		return this.children;
	}

}
