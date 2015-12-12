package ziomek.krzysztof.yourmd;

import org.junit.Assert;
import org.junit.Test;
import ziomek.krzysztof.yourmd.dao.FileReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Krzysztof Ziomek
 * @since 12/12/2015.
 */
public class FileReaderTest {

    private static final String FILE_PATH = "static/phrases3";
    private static final int NUMBER_OF_LINES = 17163;

    @Test
    public void shouldLoadAllLines() throws IOException, URISyntaxException {

        Path path = Paths.get(ClassLoader.getSystemResource(FILE_PATH).toURI());

        FileReader fileReader = new FileReader();
        List<String> lines = fileReader.readFile(path);
        System.out.println(lines.size());
        //17163
        Assert.assertEquals(NUMBER_OF_LINES, lines.size());

    }

}
