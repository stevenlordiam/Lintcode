/*
Implement a trie with insert, search, and startsWith methods

Note 
You may assume that all inputs are consist of lowercase letters a-z
*/

/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */

class TrieNode {
	char c;
	HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
	boolean isword;
 
	public TrieNode() {}
 
	public TrieNode(char c){
		this.c = c;
	}
}

public class Solution {
	private TrieNode root;
 
	public Trie() {
		root = new TrieNode();
	}
 
	// Inserts a word into the trie.
	public void insert(String word) {
		HashMap<Character, TrieNode> children = root.children;
 
		for(int i=0; i<word.length(); i++){
			char c = word.charAt(i);
 
			TrieNode t;
			if(children.containsKey(c)){
					t = children.get(c);
			}else{
				t = new TrieNode(c);
				children.put(c, t);
			}
 
			children = t.children;
 
			//set leaf node
			if(i==word.length()-1)
				t.isword = true;    
		}
	}
 
	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieNode t = searchNode(word);
 
		if(t != null && t.isword) 
			return true;
		else
			return false;
	}
 
	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		if(searchNode(prefix) == null) 
			return false;
		else
			return true;
	}
 
	public TrieNode searchNode(String str){
		Map<Character, TrieNode> children = root.children; 
		TrieNode t = null;
		for(int i=0; i<str.length(); i++){
			char c = str.charAt(i);
			if(children.containsKey(c)){
				t = children.get(c);
				children = t.children;
			}else{
				return null;
			}
		}
 
		return t;
	}
}