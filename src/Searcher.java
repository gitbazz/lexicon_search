
/**
 * Reads the input files, looks for words in the lexicon, and prints information about where the word appears in the collection of text files that compose the lexicon.
 * 
 * @author Bazillah Zargar
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Searcher {

	/**
	 * Reference to the table of binary search trees that implements the lexicon
	 * data structure
	 */
	private HashTable table;
	/**
	 * Name of the input file storing all words that will be searched for in the
	 * lexicon data structure
	 */
	private String inputFile;

	/**
	 * Constructor for the class
	 * 
	 * @param table, the table of binary search trees that implements the lexicon
	 *        data structure
	 * @param theInputTestFile, file name of the file containing the words to be
	 *        searched
	 */
	public Searcher(HashTable table, String theInputTestFile) {
		this.table = table;
		inputFile = theInputTestFile;
	}

	/**
	 * Reads the input file and for each word in it invokes the method findWord() to
	 * look for the word in the lexicon and print information about where the word
	 * appears in the collection of text files that compose the lexicon.
	 */
	public void findAllWords() {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(inputFile));
			String line;

			while ((line = in.readLine()) != null) {
				String[] words = line.split("[\\s]+");
				for (String word : words) {
					findWord(word);
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					System.err.println("Caught IOException: " + e.getMessage());
				}
			}
		}
	}

	/**
	 * Looks for searchWord in the lexicon. Prints a message about whether or not
	 * word was found in the lexicon. Also writes in an output file a message
	 * indicating whether or not the file was found in the lexicon.
	 * 
	 * @param searchWord the word being searched for in the lexicon
	 */
	public void findWord(String searchWord) {
		// Determine the index j of the entry of table that might contain searchWord.
		int j = table.computeIndex(searchWord);
		BinSearchTree[] tbl = table.getTable();
		BinSearchTreeNode nodeStoringWord = tbl[j].getWord(searchWord);

		// If searchWord is not in the binary search tree stored in table[j]
		if (nodeStoringWord == null) {
			CustomPrinter.wordNotFound(searchWord, inputFile);
		}
		// If searchWord was found in some node of the binary search tree referenced
		// by table[j]
		else {
			CustomPrinter.wordFound(searchWord, inputFile);

			LinkedList Lp = nodeStoringWord.getFiles();
			Iterator<FileNode> iterator = Lp.iterator();
			while (iterator.hasNext()) {
				FileNode q = iterator.next();
				ArrayList<Integer> lq = q.getPositions();
				CustomPrinter.printPositionsPerFileFound(q.getFilename(), lq, inputFile);
			}
		}

	}

}
