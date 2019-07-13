package trie;

import java.util.HashMap;

public class TrieNode {
	public char c;
	public HashMap<Character, TrieNode> children;

	public TrieNode() {
		children = new HashMap<Character, TrieNode>();
	}
}