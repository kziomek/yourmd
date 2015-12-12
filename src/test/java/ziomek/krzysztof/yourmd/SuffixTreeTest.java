package ziomek.krzysztof.yourmd;

import org.junit.Before;
import org.junit.Test;
import ziomek.krzysztof.yourmd.model.suffixtree.SuffixTree;
import ziomek.krzysztof.yourmd.service.InferenceService;
import ziomek.krzysztof.yourmd.service.SuffixTreeService;

import java.util.*;

/**
 * @author Krzysztof Ziomek
 * @since 12/12/2015.
 */
public class SuffixTreeTest {

    List<String> lines;

    @Before
    public void setUp() {
        lines = new LinkedList<>();
        lines.add("hypertensive disorder");
        lines.add("HTN");
        lines.add("hypertension");
        lines.add("hypertensive disorder, systemic arterial");
        lines.add("bp - high blood pressure");
        lines.add("systemic arterial hypertension");
        lines.add("HBP");
        lines.add("headache");
        lines.add("high blood pressure");
        lines.add("HT");
        lines.add("tension-type headache");
        lines.add("tension headache");
        lines.add("psychogenic headache");
        lines.add("stress headache");
        lines.add("muscular headache");
        lines.add("canker sore");
        lines.add("pressure sore of buttock");
        lines.add("chronic sore throat");
        lines.add("sore throat - chronic");
        lines.add("sore throat");
        lines.add("persistent sore throat");
        lines.add("sore pain");
        lines.add("throat pain");
        lines.add("throat discomfort");

    }

    @Test
    public void shouldBuildTreeWithOneWord() {
        String word = "hello";
        SuffixTree suffixTree = new SuffixTree();
        suffixTree.addWord(word, 1);
        suffixTree.print();
        //TODO Assert

    }

    @Test
    public void shouldBuildTreeWithOverlappingWords() {
        String word1 = "hello";
        String word2 = "helloween";
        SuffixTree suffixTree = new SuffixTree();
        suffixTree.addWord(word1, 1);
        suffixTree.addWord(word2, 2);
        suffixTree.print();
        //TODO Assert
    }

    @Test
    public void shouldBuildTreeWithCleavedWords() {
        String word1 = "hello";
        String word2 = "help";
        SuffixTree suffixTree = new SuffixTree();
        suffixTree.addWord(word1, 1);
        suffixTree.addWord(word2, 2);
        suffixTree.print();
        //TODO Assert
    }

    @Test
    public void shouldBuildTreeWithNotOverlappingWord() {
        String word1 = "hello";
        String word2 = "bye";
        SuffixTree suffixTree = new SuffixTree();
        suffixTree.addWord(word1, 1);
        suffixTree.addWord(word2, 2);
        suffixTree.print();
        //TODO Assert
    }

    @Test
    public void shouldBuildTreeWithAllLines() {

        SuffixTree suffixTree = new SuffixTree();
        for (String line : lines) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                suffixTree.addWord(word, 1);
            }
        }
        suffixTree.print();
        //TODO Assert
    }

    @Test
    public void shouldFindBestMatchingPhrases() {

        SuffixTreeService suffixTreeService = new SuffixTreeService();
        String[] linesArray = lines.toArray(new String[0]);
        SuffixTree suffixTree = suffixTreeService.buildSuffixTree(linesArray);

        suffixTree.print();

        List<String> query = new LinkedList<>();

        String headacheWord = "headache";
        Set<Integer> headacheIdx = suffixTree.findPhrases(headacheWord);
        System.out.println(headacheWord + " " + headacheIdx);
        for (Integer i : headacheIdx) {
            System.out.println(linesArray[i]);
        }

        String soreWord = "sore";
        Set<Integer> soreIdx = suffixTree.findPhrases(soreWord);
        System.out.println(soreWord + " " + soreIdx);
        for (Integer i : soreIdx) {
            System.out.println(linesArray[i]);
        }

        String throatWord = "throat";
        Set<Integer> throatIdx = suffixTree.findPhrases(throatWord);
        System.out.println(throatWord + " " + throatIdx);
        for (Integer i : throatIdx) {
            System.out.println(linesArray[i]);
        }
        //TODO Assert

        Map<String,Set<Integer>> queryResponse = new HashMap<>();
        queryResponse.put(headacheWord, headacheIdx);
        queryResponse.put(soreWord, soreIdx);
        queryResponse.put(throatWord, throatIdx);


        InferenceService inferenceService = new InferenceService();
        String headachePhrase = inferenceService.findBestMatchingSet(linesArray, headacheIdx, soreIdx, throatIdx);
        System.out.println(headacheWord + " filtered " + headachePhrase);

        String sorePhrase = inferenceService.findBestMatchingSet(linesArray, soreIdx, headacheIdx, throatIdx);
        System.out.println(soreWord + " filtered " + sorePhrase);

        String throatPhrase = inferenceService.findBestMatchingSet(linesArray, throatIdx, soreIdx, headacheIdx);
        System.out.println(throatWord + " filtered " + throatPhrase);

        Set<String> bestMatchingSet = new HashSet<>();
        bestMatchingSet.add(headachePhrase);
        bestMatchingSet.add(sorePhrase);
        bestMatchingSet.add(throatPhrase);

        System.out.println(bestMatchingSet);
    }


}
