package Trie;

import java.util.HashMap;

public class TrieNode {
    public HashMap <Character, TrieNode> child;
    public boolean end;

    public TrieNode(){
        this.child = new HashMap<>();
        this.end = false;
    }

}
