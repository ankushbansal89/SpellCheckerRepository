import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 * SpellChecker.java
 * 
 * SpellChecker class implements SpellCheckerInterface and defines functionality for basic spell checker.
 * If word is spelled incorrectly, then asterisk is appended at the end of the word.
 * 
 */

/**
 * @author Ankush Bansal
 * @since 08-21-2014
 *
 */
public class SpellChecker implements SpellCheckerInterface {

	/* (non-Javadoc)
	 * @see SpellCheckerInterface#readDictionary(Trie)
	 */
	@Override
	public TrieInterface readDictionary( TrieInterface trie, String filename ) {
		try {
			File file =  new File( filename );
			Scanner s = new Scanner( file );
			while ( s.hasNext() ) {
				String str = s.next();
				// Adding string to the trie
				trie.add(str);
			}
			s.close();
		}catch( FileNotFoundException e) {
			System.out.println( e );
		}
		return trie;
	}

	/* (non-Javadoc)
	 * @see SpellCheckerInterface#createTrie()
	 */
	@Override
	public TrieInterface createTrie() {
		TrieInterface trie = new Trie();
		return trie;
	}

	/* (non-Javadoc)
	 * @see SpellCheckerInterface#analyseText(Trie)
	 */
	@Override
	public void analyseText(TrieInterface trie, String filename) {
		try {
			File file = new File( filename );
			Scanner s = new Scanner( file );
			PrintWriter out = new PrintWriter("result.txt");
			
			while ( s.hasNext() ) {
				String str = s.next();
				String tempstr = str.replaceAll("(?!\")\\p{Punct}", "");
				// Check if whether word is present in trie or not
				if ( trie.contains(tempstr) ) {
					out.print(str+" ");
				}else {
					// if word is not correct, an asterisk is appended at the end of the word  
					out.print( str + "* ");
				}
			}
			out.close();
			s.close();
		}catch ( FileNotFoundException e) {
			System.out.println(e);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpellCheckerInterface spellchecker = new SpellChecker();
		// Reading the dictionary file path
		System.out.print(" Enter dictionary file path: ");
		Scanner s = new Scanner( System.in );
		String filename1 = "";
		if ( s.hasNext() ) {
			filename1 = s.next();
		}
		
		// Reading the document file path
		System.out.println("Enter document file path: ");
		String filename2 = "";
		if ( s.hasNext() ) {
			filename2 = s.next();
		}
		
		long start = System.currentTimeMillis();
		
		// Creating trie data structure 
		System.out.println("Creating a trie...");
		TrieInterface trie = spellchecker.createTrie();
		
		// Initializing trie with the words in the dictionary file
		System.out.println("Inserting dictionary word inside the trie...");
		trie = spellchecker.readDictionary( trie, filename1 );
		
		// Reading the document and matching it with the words in the trie
		System.out.println("Spell checking the document...");
		spellchecker.analyseText(trie, filename2);
		
		long end = System.currentTimeMillis();
		
		System.out.println("\nComputed: "+ (end-start)/1000 + "s");
		
		s.close();
	}
}
