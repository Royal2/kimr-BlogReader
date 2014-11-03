package android.kimr.blogreader;

public class BlogPost {
    public final String title;
    public final String date;
    public final String author;
    public final String thumbnail;
    public final String url;

    //list items: title, date, author.
    public BlogPost(String title, String date, String author, String thumbnail, String url ){
        this.title = title;
        this.date = date;
        this.author = author;
        this.thumbnail = thumbnail;
        this.url = url;
    }

    //Converts to string.
    @Override
    public String toString() {
        return title;
    }
}