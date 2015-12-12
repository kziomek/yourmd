package ziomek.krzysztof.yourmd.model.suffixtree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Krzysztof Ziomek
 * @since 12/12/2015.
 */
public class Node {

    protected Character letter;
    protected Map<Character, Node> children;
    private Set<Integer> phraseIDs;


    protected Node() {
        children = new HashMap<>();
    }

    public Node(Character letter) {
        this.letter = letter;
        children = new HashMap<>();
        phraseIDs = new HashSet<>();
    }

    public Character getLetter() {
        return letter;
    }

    public void setLetter(Character letter) {
        this.letter = letter;
    }

    public Map<Character, Node> getChildren() {
        return children;
    }

    public void setChildren(Map<Character, Node> children) {
        this.children = children;
    }

    public Set<Integer> getPhraseIDs() {
        return phraseIDs;
    }

    public void setPhraseIDs(Set<Integer> phraseIDs) {
        this.phraseIDs = phraseIDs;
    }
}
