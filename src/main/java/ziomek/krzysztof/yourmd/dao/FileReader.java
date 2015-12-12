package ziomek.krzysztof.yourmd.dao;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Krzysztof Ziomek
 * @since 12/12/2015.
 */
public class FileReader {

    @Deprecated
    public List<String> readFile() throws URISyntaxException, IOException {
        String filename = "static/phrases3";
        Path path = Paths.get(ClassLoader.getSystemResource(filename).toURI());
        return readFile(path);
    }

    public List<String> readFile(String filePath) throws URISyntaxException, IOException {
        Path path = Paths.get(ClassLoader.getSystemResource(filePath).toURI());
        return readFile(path);
    }

    public List<String> readFile(Path path) throws IOException {
        return Files.lines(path).collect(Collectors.toList());
    }


}
