package SuffixTrie;

import Trie.*;

public class SuffixTrie extends Trie {
    public void constructTree(String word) {
        for (int i = 0; i < word.length(); i++) {
            insert(word.substring(i));
        }
    }
//----------------------------------------------------------------
    public void traverseSuffixes() {
        traverseSuffixes(root, "");
    }
//----------------------------------------------------------------
    private void traverseSuffixes(TrieNode node, String suffix) {
        if (node.end) {
            System.out.println("Suffix: " + suffix);
        }

        for (var entry : node.child.entrySet()) {
            char key = entry.getKey();
            TrieNode childNode = entry.getValue();
            traverseSuffixes(childNode, suffix + key);
        }
    }

}


