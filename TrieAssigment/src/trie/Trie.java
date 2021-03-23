package trie;


public class Trie {
	Exception wordException = new Exception("Invalid word");
	Node head;

	public Trie(String word) throws Exception {
		init(word);
	}

	/**
	 * add the word to the new trie
	 * head is a pointer for the trie root node
	 * @param word
	 * @throws Exception
	 */
	private void init(String word) throws Exception {
		if(word == null || word.isEmpty())
			throw wordException;
		System.out.println("Start init " + word);

		this.head = new Node(word.charAt(0));
		System.out.println(word.charAt(0));
		word = word.substring(1);
		if(word.length() > 1) {
			Node newNode = new Node(word.charAt(0));
			System.out.println(word.charAt(0));

			this.head.addNode(newNode);
			addWord(newNode, word.substring(1));
		}else if(!word.isEmpty()){
			Node newNode = new Node(word.charAt(0));
			this.head.addNode(newNode);
		}
	}


	public void insert(String word) throws Exception {
		if(word == null || head.val != word.charAt(0) || word.isEmpty())
			throw wordException;

		boolean flag = false;
		word = word.substring(1);

		if(word.length() > 0) {
			for(Node n: head.getNextNodes()) {
				if(n.val == word.charAt(0)) {
					handleInsert(n, word.substring(1));
					flag = true;
				}
			}
			if(!flag) {
				Node newNode = new Node(word.charAt(0));
				head.addNode(newNode);
				addWord(newNode, word);
			}
		}
	}

	private void addWord(Node node, String word){
		Node currentNode = node;
		while(word.length() > 0) {
			Node nextNode = new Node(word.charAt(0));
			System.out.println(word.charAt(0));
			currentNode.addNode(nextNode);
			currentNode = nextNode;
			word = word.substring(1);
		}
	}

	private void handleInsert(Node node, String word) throws Exception {

		//breaking condition
		if(word.length() == 1) {
			if(node.getNextNodes().size() > 0) {
				for(Node n: node.getNextNodes()) {
					if(word.charAt(0) == n.val) 
						return;
				}
			}
			Node newNode = new Node(word.charAt(0));
			node.addNode(newNode);
			return;
		}

		boolean flag = false;

		for(Node n: node.getNextNodes()) {
			if(word.charAt(0) == n.val) { 
				flag = true;
				handleInsert(n, word.substring(1));
			}
		}
		if(!flag) {
			Node newNode = new Node(word.charAt(0));
			node.addNode(newNode);
			addWord(newNode, word);
		}
	}

	public boolean search(String word) throws Exception {
		if(word == null || word.isEmpty() || head.val != word.charAt(0))
			throw wordException;

		return searchWord(this.head, word);
	}

	private boolean searchWord(Node node, String word) {
		boolean isExist = false;
		//breaking condition
		if(word.length() == 1) {
			return word.charAt(0) == node.val;
		}

		if(word.charAt(0) == node.val) {
			for(Node n: node.getNextNodes()) {
				if(n.val == word.charAt(1))
					return searchWord(n, word.substring(1));
			}
		}
		return false;
	}

	/**
	 * 
	 * @param word
	 * @return
	 * @throws Exception
	 */
	public boolean remove(String word) throws Exception {
		if(word == null || word.isEmpty() || head.val != word.charAt(0))
			throw wordException;

		Node currentNode = this.head;
		Node branch = this.head;
		if(search(word)) {
			word = word.substring(1);
			while(word.length() > 1) {
				for(Node n: currentNode.getNextNodes()) {
					if(n.val == word.charAt(0)) {
						if(currentNode.getNextNodes().size() > 1) 
							branch = currentNode;
						currentNode = n;
					}
				}
				word = word.substring(1);
			}
			for(Node n: branch.getNextNodes()) {
				if(n.val == word.charAt(0))
					return branch.getNextNodes().remove(n);
			}
		}
		return false;
	}
}


