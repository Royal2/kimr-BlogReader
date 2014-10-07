package android.kimr.blogreader;

import org.json.JSONObject;

import java.io.InputStream;

public class BlogPostParser {
    private static BlogPostParser parser;
    private BlogPostParser() {

    }

    public static BlogPostParser get() {
        if(parser == null){

        }
        return parser;
    }

    public JSONObject parse(InputStream inputStream) {
        return null;
    }
}
