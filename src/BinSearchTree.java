/**
 * Uses a linked structure to implement a binary search tree.
 * 
 * @author Bazillah Zargar
 */

public class BinSearchTree {

	// Reference to the root node of the binary search tree.
	private BinSearchTreeNode root;

	/**
	 * Searches for a given word in the binary search tree and returns the node
	 * storing that word.
	 * 
	 * @param searchWord, the word being searched for in the binary search tree
	 * @return the node of the binary search tree storing searchWord, or null if no
	 *         node stores it
	 */
	public BinSearchTreeNode getWord(String searchWord) {
		BinSearchTreeNode nodeStoringWord = search(root, searchWord);
		return nodeStoringWord;
	}

	/**
	 * Auxiliary method for getWord(). Searches for a given word in the binary
	 * search tree and returns the node storing that word.
	 * 
	 * @param r, the root node of the binary search tree
	 * @param searchWord, the word being searched for in the binary search tree
	 * @return the node of the binary search tree storing searchWord, or null if no
	 *         node stores it
	 */
	private BinSearchTreeNode search(BinSearchTreeNode r, String searchWord) {
		// Check if tree is empty
		if (r == null) {
			return null;
		}
		//
		else {
			if (r.getWord().equals(searchWord)) {
				return r;
			} else if (searchWord.compareTo(r.getWord()) < 0) {
				return search(r.getLeft(), searchWord);
			} else {
				return search(r.getRight(), searchWord);
			}
		}
	}

	/**
	 * Inserts a given word at the appropriate node in the binary search tree along
	 * with information about the filename and position of the word in the file. If
	 * some node already stores theWord, then theFileName and thePosition are added
	 * to the information stored in that node. If no node in the binary search tree
	 * stores theWord then a new node of type BinSearchTreeNode storing theWord,
	 * theFileName and thePosition is added to the binary search tree.
	 * 
	 * @param theWord, the word to be inserted in the binary search tree.
	 * @param theFileName, the name of the file that contains the word.
	 * @param thePosition, the position of the word in the file.
	 */
	public void insertWord(String theWord, String theFileName, int thePosition) {
		BinSearchTreeNode p = getWord(theWord);
		if (!(p == null)) {
			LinkedList Lp = getWord(theWord).getFiles();
			Lp.insertWord(theFileName, thePosition);
		} else {
			insert(root, theWord, theFileName, thePosition);
		}
	}

	/**
	 * Auxiliary method for insertWord(). Inserts a new node of type
	 * BinSearchTreeNode storing theWord, theFileName and thePosition in the binary
	 * search tree.
	 * 
	 * @param r, the root node of the binary search tree
	 * @param theWord, the word to be inserted in the binary search tree.
	 * @param theFile, the name of the file that contains the word.
	 * @param thePosition, the position of the word in the file.
	 */
	private void insert(BinSearchTreeNode r, String theWord, String theFile, int thePosition) {
		// Check if tree is empty
		if (r == null) {
			BinSearchTreeNode newNode = new BinSearchTreeNode(theWord, theFile, thePosition);
			root = newNode;
		} else if (theWord.compareTo(r.getWord()) < 0) {
			if (r.getLeft() == null) {
				BinSearchTreeNode newNode = new BinSearchTreeNode(theWord, theFile, thePosition);
				r.setLeft(newNode);
			} else {
				insert(r.getLeft(), theWord, theFile, thePosition);
			}
		} else {
			if (r.getRight() == null) {
				BinSearchTreeNode newNode = new BinSearchTreeNode(theWord, theFile, thePosition);
				r.setRight(newNode);
			} else {
				insert(r.getRight(), theWord, theFile, thePosition);
			}
		}
	}

}
