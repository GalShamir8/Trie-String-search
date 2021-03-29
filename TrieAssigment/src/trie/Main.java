package trie;


public class Main {
	public static final String [] ALL_NAMES= {"Amit", "Amil", "Amir", "Amira"
			, "Avira", "Aml", "Aharon", "Aviahu", "Avri", "Anan"};
	
	public static void main(String[] args) throws Exception {
		Trie trie = hardCoded();
		testTrie(trie);
	}

	private static void testTrie(Trie trie) {
		try {
			System.out.println("\n-------------------------------------------------\n");
			for(String word: ALL_NAMES)
				System.out.println(word + " exist? " + trie.search(word));
			System.out.println("\n-------------------------------------------------\n");
			System.out.println("-----------After remove Amit and Avira-----------");
			trie.remove("Amit");
			trie.remove("Avira");
			for(String word: ALL_NAMES)
				System.out.println(word + " exist? " + trie.search(word));
			System.out.println("\n-------------------------------------------------\n");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static Trie hardCoded() {
		Trie t = null;
		try {
		t = new Trie(ALL_NAMES[0]);
		for(String word: ALL_NAMES)
			t.insert(word);
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return t;
	}

}
