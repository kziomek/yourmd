package ziomek.krzysztof.yourmd.service;

import org.springframework.stereotype.Service;
import ziomek.krzysztof.yourmd.model.suffixtree.SuffixTree;

/**
 * @author Krzysztof Ziomek
 * @since 12/12/2015.
 */
@Service
public class SuffixTreeService {

    public SuffixTree buildSuffixTree(String[] lines) {
        SuffixTree suffixTree = new SuffixTree();
        for (int i = 0; i < lines.length; i++) {
            String[] words = lines[i].split("\\s+");
            for (String word : words) {
                suffixTree.addWord(word, i);
            }

        }
        return suffixTree;
    }

}
