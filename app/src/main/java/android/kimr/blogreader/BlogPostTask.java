package android.kimr.blogreader;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

//BlogPostTask inherits all the properties of AsyncTask.
public class BlogPostTask extends AsyncTask<Activity, Void, JSONObject> {
    private Activity activity;

    @Override
    protected JSONObject doInBackground(Activity... activities) {
        activity = activities[0];
        JSONObject jsonObject = null;

        //Bitmap bm = null;

        try {
            URL blogFeedUrl = new URL("http://blog.teamtreehouse.com/api/get_recent_summary/?count=20");

            //Connects and gets the activities.
            HttpURLConnection connection = (HttpURLConnection) blogFeedUrl.openConnection();
            connection.connect();
            int responseCode = connection.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK) {
                Log.i("BlogPostTask", "Successful Connection " + responseCode);
                jsonObject = BlogPostParser.get().parse(connection.getInputStream());
            }

            //URL aURL = new URL("http://blog.teamtreehouse.com/api/get_recent_summary/?count=20");
            //URLConnection conn = aURL.openConnection();
            //conn.connect();
            //InputStream is = conn.getInputStream();
            //BufferedInputStream bis = new BufferedInputStream(is);
            //bm = BitmapFactory.decodeStream(bis);
            //bis.close();
            //is.close();

        }
        catch(MalformedURLException error){
            Log.e("BlogPostTask", "Malformed URL: " + error);
        }
        catch (IOException error) {
            Log.e("BlogPostTask", "IO Exception: " + error);
        }
        return jsonObject;
    }

    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        BlogPostParser.get().readFeed(jsonObject);
        GridView gridView = (GridView)activity.findViewById(R.id.gridView);

        //ArrayAdapter<BlogPost> adapter = new ArrayAdapter<BlogPost>(activity, android.R.layout.simple_list_item_1, BlogPostParser.get().posts);
        BlogPostAdapter adapter = new BlogPostAdapter(activity, BlogPostParser.get().posts);
        gridView.setAdapter(adapter);
        //super.onPostExecute(jsonObject);
    }
}