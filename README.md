# Lexicon Search

Allows users to search for words in a collection C of documents stored in text files. 
More specifically, a user can search files, and the location in these files, where a particular word exists. 
The program receives as input a file I containing a list of words to search in the lexicon. 
It reads the files in collection C and stores the words contained in these files in a lexicon data structure that holds location information about the different words. 
This data structure is an array in which every entry stores a binary search tree. 
Every node of a binary search tree stores a word w and a list of files where the word appears; for each file the data structure also stores a list of positions within this file where the word w appears. 
Once the program has stored the words in the lexicon data structure, the input file I will be read. 
Each word in I will be searched in the lexicon and information about the files that contain the word and the positions of the word in the files will be printed. 

**BinSearchTree.java** class that uses a linked structure to implement a binary search tree in the lexicon data structure. 

**BinSearchTreeNode.java** class that represents a node of the binary search tree.

**Searcher.java** class that reads the input file and for each word w looks for the word in the lexicon and prints information about where the word appears in the collection of text files that compose the lexicon.

**CustomPrinter.java** class that contains methods to print custom messages for the output.

**FileNode.java** class that represents a node in the singly linked list containing the files and the positions in each file
where a word is found.

**LinkedList.java** class that implements a singly linked list of FileNode objects.

**HashTable.java** class that represents the array that stores the binary search trees. 

**InputFileReader.java** class that reads all text files in the input folder and add all their words to the lexicon.

**Lexicon.java** class that contains the main method.It initializes the table of binary search trees, reads the text files and adds their words to the table. Then, the words in the input file are searched and the results of the searches are printed in the console and saved in an output file. The program takes one argument in its main method: the name of the file that contains the words to be searched.

**LinkedIterator.java** class that provides a glimpse of Java’s utilities to traverse collections. 

**Comparator.java** class that has a main method that receives as parameter the name of an input file. This method compares the output produced by the program (for example, output_test1.txt) with the expected correct file  (for example, correct_output_test1.txt).

