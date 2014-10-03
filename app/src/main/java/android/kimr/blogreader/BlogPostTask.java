package android.kimr.blogreader;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

//BlogPostTask inherits all the properties of AsyncTask.
public class BlogPostTask extends AsyncTask<Activity, Void, JSONObject> {
    @Override
    protected JSONObject doInBackground(Activity... activities) {
        try {
            URL blogFeedUrl = new URL("http://blogs.teamtreehouse.com/api/get_recent_summary/?count");

            HttpURLConnection connection = (HttpURLConnection) blogFeedUrl.openConnection();
            connection.connect();
            int responseCode = connection.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK) {
                Log.i("BlogPostTask", "Successful Connection " + responseCode);
            }
        }
        catch(MalformedURLException error){
            Log.e("BlogPostTask", "Malformed URL: " + error);
        }
        catch (IOException error) {
            Log.e("BlogPostTask", "IO Exception: " + error);
        }
        return null;
    }
}