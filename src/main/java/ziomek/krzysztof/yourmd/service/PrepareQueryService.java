package ziomek.krzysztof.yourmd.service;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author Krzysztof Ziomek
 * @since 12/12/2015.
 */
@Component
public class PrepareQueryService {

    private Set<String> blankWordSet;

    public PrepareQueryService() {
        //TODO read from repository
        blankWordSet = new HashSet<>();
        blankWordSet.add("and");
        blankWordSet.add("I");
        blankWordSet.add("have");
        //TBC
    }

    public void filterBlankWords(List<String> query) {

        Iterator<String> iterator =  query.iterator();
        while (iterator.hasNext()) {
            String elem = iterator.next();
            if (blankWordSet.contains(elem)) {
                iterator.remove();
            }
        }

    }
}
