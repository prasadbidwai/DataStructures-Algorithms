package trie;

import java.util.HashMap;

/**
 * LeetCode Problem 211: Add and Search Word - Data structure design
 */
public class WordDictionary {

	TrieNode root;

	/** Initialize your data structure here. */
	public WordDictionary() {
		root = new TrieNode();
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		word = word.concat("/");
		HashMap<Character, TrieNode> currentLevel = root.children;
		
		for (char c : word.toCharArray()) {
			if (!currentLevel.containsKey(c)) {
				TrieNode tempNode = new TrieNode();
				tempNode.c = c;
				currentLevel.put(c, tempNode);
			}
			currentLevel = currentLevel.get(c).children;
		}
	}

	/**
	 * Returns if the word is in the data structure. A word could contain the
	 * dot character '.' to represent any one letter.
	 */
	public boolean search(String word) {
		word = word.concat("/");
		HashMap<Character, TrieNode> currentLevel = root.children;
		char[] wordArray = word.toCharArray();
		
		for (int i = 0; i < wordArray.length; i++) {
			char c = wordArray[i];
			if (c == '.') {
				return searchRegex(word.substring(i + 1), currentLevel);
			} else {
				if (!currentLevel.containsKey(c)) {
					return false;
				}
				currentLevel = currentLevel.get(c).children;
			}
		}
		return true;
	}

	private boolean searchRegex(String word, HashMap<Character, TrieNode> children) {
		for (TrieNode node : children.values()) {
			HashMap<Character, TrieNode> currentLevel = node.children;
			char[] wordArray = word.toCharArray();
			boolean result = true;
			for (int i = 0; i < wordArray.length; i++) {
				char c = wordArray[i];
				if (c == '.') {
					result = searchRegex(word.substring(i + 1), currentLevel);
					break;
				} else {
					if (!currentLevel.containsKey(c)) {
						result = false;
						break;
					}
					currentLevel = currentLevel.get(c).children;
				}
			}
			if (result == true) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Your WordDictionary object will be instantiated and called as such:
	 * WordDictionary obj = new WordDictionary(); obj.addWord(word); boolean
	 * param_2 = obj.search(word);
	 */
	public static void main(String[]args) {
		WordDictionary obj = new WordDictionary();
		obj.addWord("bad");
		obj.addWord("dad");
		obj.addWord("mad");
		
		System.out.println(obj.search(".a."));
		System.out.println(obj.search("bad"));
		System.out.println(obj.search("..d."));
		System.out.println(obj.search("a"));
		System.out.println(obj.search(".ad"));
		System.out.println(obj.search("b.."));

	}

}