package ziomek.krzysztof.yourmd.model.suffixtree;

import java.util.Set;

/**
 * @author Krzysztof Ziomek
 * @since 12/12/2015.
 */
public class SuffixTree {

    protected Node root;

    public SuffixTree() {
        root = new Root();
    }

    public void addWord(String word, int phraseId) {
        if (word == null || word.length() == 0) {
            return;
        }
        add(word.toCharArray(), 0, root, phraseId );
    }

    private void add(char[] word, int currIdx, Node parentNode, int phraseId) {
        Character c = word[currIdx];
        Node node = parentNode.getChildren().get(c);
        if (node == null) {
            node = new Node(word[currIdx]);
            parentNode.getChildren().put(c,node);
        }
        /* If last letter than add leaf Node */
        if (currIdx == word.length - 1) {
            node.getPhraseIDs().add(phraseId);
        } else { // add Node
            add (word, ++currIdx, node, phraseId);
        }

    }

    public Set<Integer> findPhrases(String queryWord) {
        return findPhrases(queryWord.toCharArray(), 0, root);
    }

    public Set<Integer> findPhrases(char[] word, int currIdx, Node parentNode) {
        Character c = word[currIdx];
        Node node = parentNode.getChildren().get(c);
        if (node == null) {
            return null;
        }
        /* If last letter than add leaf Node */
        if (currIdx == word.length - 1) {
            return node.getPhraseIDs();
        } else { // add Node
            return findPhrases(word, currIdx + 1, node);
        }
    }

    public void print(){
        int level = 0;
        //TODO Use logger
        System.out.println("Root - level: " + level);
        print(root, level + 1);
    };

    private void print(Node parentNode, final int level) {
        parentNode.getChildren().forEach((key, node) -> {
            //TODO Use logger
            System.out.println("Tree level: " + level + " letter: " + node.getLetter() + "  phrases: " + node.getPhraseIDs());
            print(node, level + 1);
        });

    }


}
