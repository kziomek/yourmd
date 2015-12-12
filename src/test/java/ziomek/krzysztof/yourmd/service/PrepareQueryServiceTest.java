package ziomek.krzysztof.yourmd.service;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Krzysztof Ziomek
 * @since 12/12/2015.
 */
public class PrepareQueryServiceTest {

    @Test
    public void shouldBuildTreeWithOneWord() {

        PrepareQueryService prepareQueryService = new PrepareQueryService();

        String query = "I have sore throat and headache";
        List<String> queryWords = new LinkedList<>(Arrays.asList(query.split("\\s+")));

        System.out.println("Query before filter: "+ queryWords);
        Assert.assertEquals(6, queryWords.size());
        prepareQueryService.filterBlankWords(queryWords);
        System.out.println("Query after filter: "+ queryWords);
        Assert.assertEquals(3, queryWords.size());


    }
}
