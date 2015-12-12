package ziomek.krzysztof.yourmd.rs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ziomek.krzysztof.yourmd.dao.FileReader;
import ziomek.krzysztof.yourmd.dao.RepositoryFileEnum;
import ziomek.krzysztof.yourmd.model.suffixtree.SuffixTree;
import ziomek.krzysztof.yourmd.service.PrepareQueryService;
import ziomek.krzysztof.yourmd.service.SuffixTreeService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author Krzysztof Ziomek
 * @since 12/12/2015.
 */
@RestController
@RequestMapping(value = "/api/v1/yourmd", produces = MediaType.APPLICATION_JSON_VALUE)
public class YourmdController {

    @Autowired
    private SuffixTreeService suffixTreeService;

    @Autowired
    private PrepareQueryService prepareQueryService;

    @RequestMapping(method = GET, path = "lines")
    public ResponseEntity<String[]> findCollections() throws URISyntaxException, IOException {
        FileReader fileReader = new FileReader();
        String[] lines = fileReader.readFile(RepositoryFileEnum.PHRASES3.getPath()).toArray(new String[0]);

        SuffixTree suffixTree = suffixTreeService.buildSuffixTree(lines);
        //suffixTree.print();

        String query = "I have sore throat and headache";
        List<String> queryWords = new LinkedList<>(Arrays.asList(query.split("\\s+")));

        System.out.println("Query before filter: "+ queryWords);
        prepareQueryService.filterBlankWords(queryWords);
        System.out.println("Query after filter: "+ queryWords);

        return new ResponseEntity<>(lines, OK);
    }

}