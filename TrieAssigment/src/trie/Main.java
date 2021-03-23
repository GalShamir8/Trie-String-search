package trie;

public class Main {

	public static void main(String[] args) throws Exception {
		Trie t = new Trie("Amit");
		t.insert("Amir");
		System.out.println("Amir exist? " + t.search("Amir") + "\nAmit exist?" + t.search("Amit") + 
				"\nAmil exist? " + t.search("Amil"));
		t.remove("Amir");
		System.out.println("Amir exist? " + t.search("Amir") + "\nAmit exist?" + t.search("Amit") + 
				"\nAmil exist? " + t.search("Amil"));

	}

}
