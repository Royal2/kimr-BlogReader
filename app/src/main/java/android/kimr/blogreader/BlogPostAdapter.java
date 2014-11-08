package android.kimr.blogreader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BlogPostAdapter extends ArrayAdapter<BlogPost> {
    public BlogPostAdapter(Context context, ArrayList<BlogPost> posts) {
        super(context, 0, posts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BlogPost post = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_items_blog, parent, false);
        }



        //displaying list items.

        TextView textView = (TextView) convertView.findViewById(R.id.title);
        textView.setText (post.title);

        TextView author = (TextView) convertView.findViewById(R.id.author);
        author.setText (post.author);

        TextView date = (TextView) convertView.findViewById(R.id.date);
        date.setText (post.date);

        WebView thumbnail = (WebView) convertView.findViewById(R.id.thumbnail);
        //ImageView thumbnail = (ImageView) convertView.findViewById(R.id.thumbnail);

        //thumbnail.setText (post.thumbnail);
        thumbnail.loadUrl(post.thumbnail);

        //TextView thumbnail = (TextView) convertView.findViewById(R.id.thumbnail);
        //date.setText (post.thumbnail);

        return convertView;
    }
}
