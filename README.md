SpellCheckerRepository
======================

Designing a spell checker capable of finding misspelled words in a text file.Given a dictionary file containing a list of valid words (dictionaty.txt). Taking into account that the text file to check might be extremely large. 

Testing the program with les-miserable.txt and outputing it in result.text.

This spell checker uses Trie data structure. The main reasons for using trie are:

1) Efficient store
2) Easier matching
3) Easier to add other related functionality like finding suffix or correct word suggestions

How to run the program
------------------------
------------------------

1) Clone the repository 
2) Import project in the eclipse
3) Execute SpellChecker.java
4) Will be prompted for Dictionary path and Document path
5) Once provided with the required information, spell checking will start.
6) Final result is output in the result.txt with incorrect words appended with asterisk(*)
