package ziomek.krzysztof.yourmd.dao;

/**
 * @author Krzysztof Ziomek
 * @since 12/12/2015.
 */
public enum RepositoryFileEnum {
    
    PHRASES3("static/phrases3");

    private final String path;

    RepositoryFileEnum(String iPath) {
        path = iPath;
    }

    public String getPath() {
        return path;
    }
}
