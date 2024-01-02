import SuffixTrie.SuffixTrie;
import Trie.Trie;

public class Main {
    public static void main(String[] args) {
        System.out.println("Trie :");
        Trie trie = new Trie();
        trie.insert("abc");
        trie.insert("abgl");
        trie.insert("lmn");
        trie.traverse();
        trie.delete("abc");
        trie.traverse();
        System.out.println(trie.search("abc"));
        System.out.println(trie.prefixSearch("ab"));
        trie.delete("abc");

        //----------------------------------------------------------------

        SuffixTrie suffixTrie = new SuffixTrie();
        System.out.println("________________________________________________________________");
        System.out.println("SuffixTrie :");
        suffixTrie.constructTree("banana$");
        suffixTrie.traverseSuffixes();

    }
}