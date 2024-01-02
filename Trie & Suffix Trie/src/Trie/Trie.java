package Trie;

public class Trie {
    public TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    //----------------------------------------------------------------

    public void insert(String word){
        TrieNode current = root;    // Start at the root.
        for (char c : word.toCharArray()){
            TrieNode node = current.child.get(c);
            if (node == null){  // If we didn't find the character then just put it.
                node = new TrieNode();
                current.child.put(c, node);
            }
            current = node;
        }
        current.end = true; // Mark the end of the word.
    }


    //----------------------------------------------------------------

    public boolean prefixSearch(String word){
        TrieNode current = root;
        for(char c : word.toCharArray()){
            TrieNode node = current.child.get(c);
            if (node == null){
                return false;
            }
            current = node;
        }
        return true;
    }

    //----------------------------------------------------------------

    public boolean search(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            TrieNode node = current.child.get(c);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.end;
    }

    //----------------------------------------------------------------
    public void delete(String word) {
        if (search(word)) {
            delete(word,root,0);
            System.out.println("Word deleted successfully !!!");
            return;
        }
        System.out.println("Word not found !!!");
    }

    public boolean delete (String word, TrieNode current, int index){
        if (index == word.length()) {   // In case of the last character in the word.
            if(!current.end){   // If we still not reach the end.
                return false;
            }
            current.end = false;    // If we reach the end then switch the end of the word into false.
            return current.child.size() == 0;   // check if there are any other children "words".
        }

        char c = word.charAt(index);
        TrieNode node = current.child.get(c);   // get the next character.

        if (node == null){  // null safety.
            return false;
        }

        boolean delete = delete(word,node,index+1);   // recursively call the function.
        if (delete){
            current.child.remove(c);    // remove the character.
            return current.child.size() == 0;
        }
        return false;
    }

    //----------------------------------------------------------------

    public void traverse() {
        traverse(root, "");
    }

    private void traverse(TrieNode node, String word) {
        if (node.end) {
            System.out.println(word);
        }

        for (var entry : node.child.entrySet()) {
            char key = entry.getKey();
            TrieNode childNode = entry.getValue();
            traverse(childNode, word + key);
        }
    }

    //----------------------------------------------------------------
}
