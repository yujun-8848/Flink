package leetcode.String;

public class Tire {

    private TrieNode root;

    public Tire() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char[] chars = word.toCharArray();
            if (!node.containsKey(chars[i])) {
                node.put(chars[i], new TrieNode());
            }
            node = node.get(chars[i]);
        }
        node.setEnd();
    }

    public TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char[] chars = word.toCharArray();
            if (node.containsKey(chars[i])) {
                node = node.get(chars[i]);
            } else {
                return null;
            }
        }
        return node;
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    public static void main(String[] args) {
        Tire tire = new Tire();
        tire.insert("apple");
        boolean app = tire.search("app");
        tire.insert("app");
        boolean search = tire.search("app");
        System.out.println();

    }
}
