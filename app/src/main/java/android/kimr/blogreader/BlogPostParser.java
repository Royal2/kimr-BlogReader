package android.kimr.blogreader;

public class BlogPostParser {
    private static BlogPostParser parser;
    private BlogPostParser() {

    }

    public static BlogPostParser get() {
        if(parser == null){

        }
        return parser;
    }
}
