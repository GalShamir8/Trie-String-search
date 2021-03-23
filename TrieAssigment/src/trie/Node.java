package trie;

import java.util.ArrayList;

public class Node {
	char val;
	ArrayList<Node> allNodes;

	
	public Node(char val) {
		this.val = val;
		allNodes = new ArrayList<>();
	}

	public void addNode(Node next){
		allNodes.add(next);
	}
	
	public char getVal() {
		return val;
	}

	public ArrayList<Node> getNextNodes() {
		return allNodes;
	}

	
	
	
}
