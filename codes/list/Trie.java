import java.util.HashMap;
import java.util.Map;

public class Trie {
    
    public class TrieNode {
        Character c; 
        Map<Character, TrieNode> map = new HashMap<>();
        
        TrieNode(Character c ) {this.c = c;}
    }


}
