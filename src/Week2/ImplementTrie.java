/*
 * 208. Implement Trie (Prefix Tree)
 * 
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * 	Example:
 * 
 * 		Trie trie = new Trie();
 * 		trie.insert("apple");
 * 		trie.search("apple");   // returns true
 * 		trie.search("app");     // returns false
 * 		trie.startsWith("app"); // returns true
 *		trie.insert("app");   
 *		trie.search("app");     // returns true
 *
 *	Note:
 *		You may assume that all inputs are consist of lowercase letters a-z.
 *		All inputs are guaranteed to be non-empty strings.
 * 
 * 
 * 
 */

package Week2;

import java.util.Scanner;
import java.util.StringTokenizer;

public class ImplementTrie {
	/** Initialize your data structure here. */
	class Node {
		char ch;
		Node[] table;
		boolean eow;

		Node(char c) {
			this.ch = c;
			table = new Node[26];
			eow = false;
		}
	}

	Node root;

	public ImplementTrie() {
		root = new Node('*');
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		addWord(root, word);
	}

	private void addWord(Node node, String word) {
		if (word.length() == 0) {
			node.eow = true;
			return;
		}

		char c = word.charAt(0);
		String row = word.substring(1);

		Node child = node.table[c - 'a'];
		if (child != null) {
			addWord(child, row);
		} else {
			Node temp = new Node(c);
			node.table[c - 'a'] = child = temp;
			addWord(child, row);
		}

	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		return searchWord(root, word);
	}

	private boolean searchWord(Node node, String word) {
		if (word.length() == 0) {
			return node.eow;
		}

		char c = word.charAt(0);
		String row = word.substring(1);

		Node child = node.table[c - 'a'];

		if (child == null) {
			return false;
		} else {
			return searchWord(child, row);
		}

	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		return startWithWord(root, prefix);
	}

	private boolean startWithWord(Node node, String word) {
		if (word.length() == 0) {
			return true;
		}

		char c = word.charAt(0);
		String row = word.substring(1);

		Node child = node.table[c - 'a'];

		if (child == null) {
			return false;
		} else {
			return startWithWord(child, row);
		}

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String opp = scn.next();
		String argumnet = scn.next();
		StringTokenizer oppSt = new StringTokenizer(opp, "[\\[\\],\"]");
		StringTokenizer st = new StringTokenizer(argumnet, "[\\[\\],\"]");
		
//		while(oppSt.hasMoreElements()) {
//			System.out.println(oppSt.nextToken());
//		}
//		while(st.hasMoreElements()) {
//			System.out.println(st.nextToken());
//		}
		
		ImplementTrie trie = null;
		int count = oppSt.countTokens();
		for (int i = 0; i < count; i++) {
			String s = oppSt.nextToken();
			switch (s) {
			case "Trie":
				trie = new ImplementTrie();
				System.out.print("[");
				break;
			case "insert":
				trie.insert(st.nextToken());
				System.out.print("null");
				break;
			case "search":
				System.out.print(trie.search(st.nextToken()));
				break;
			case "startsWith":
				System.out.print(trie.startsWith(st.nextToken()));
				break;

			default:
				break;
			}
			if (i != 0 && i != count - 1) {
				System.out.print(",");
			}

		}
		System.out.print("]");
		scn.close();
	}
}
