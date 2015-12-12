package ziomek.krzysztof.yourmd.service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author Krzysztof Ziomek
 * @since 12/12/2015.
 */
public class InferenceService {

    public String findBestMatchingSet(String[] linesArray, Set<Integer> mainSet, Set<Integer>... neighbourhoodSets ) {
        if (mainSet == null || mainSet.isEmpty()){
            return null;
        }
        Set<Integer> intersectionSet = new HashSet<>();

        for (Set<Integer> neighbourhoodSet : neighbourhoodSets){
            Set<Integer> tmpSet = cloneSet(mainSet);
            tmpSet.retainAll(neighbourhoodSet);
            intersectionSet.addAll(tmpSet);

        }
        Set<Integer> bestSet;
        if (intersectionSet.size() > 0){
            bestSet = intersectionSet;
        } else {
            bestSet = mainSet;
        }

        return pickLine(linesArray, bestSet);


    }

    private Set<Integer> cloneSet(Set<Integer> set) {
        return new HashSet<>(set);
    }

    private String pickLine(String[] linesArray, Set<Integer> resultSet ){
        List<String> phrases = new LinkedList<>();
        for (Integer i : resultSet) {
            phrases.add(linesArray[i]);
        }
        String minPhrase = phrases.get(0);
        for(String p : phrases) {
            if (p.length() < minPhrase.length()){
                minPhrase = p;
            }
        }
        return minPhrase;
    }
}
