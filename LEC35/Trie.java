package LEC35;
class TrieNode{
    TrieNode[] child = new TrieNode[26];
    boolean isEnd = false;
}

public class Trie {
    TrieNode root;
    public Trie() {
        root= new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0;i < word.length();i++){
            char ch = word.charAt(i);
            if(node.child[ch-'a'] == null){
                node.child[ch-'a'] = new TrieNode();
            }
            node = node.child[ch-'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for(int i= 0;i < word.length();i++){
            char ch = word.charAt(i);
            if(node.child[ch-'a'] == null)return false;

            node= node.child[ch-'a'];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i= 0;i < prefix.length();i++){
            char ch = prefix.charAt(i);
            if(node.child[ch-'a'] == null)return false;

            node= node.child[ch-'a'];
        }
        return  true;

    }

}
