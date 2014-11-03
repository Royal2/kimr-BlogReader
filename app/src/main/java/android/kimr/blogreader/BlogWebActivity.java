package android.kimr.blogreader;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class BlogWebActivity extends Activity {
    protected ProgressBar progressBar;
    protected WebView webView;
    //Web Activity progress bar --> disappear when loading is complete.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_web);

        progressBar = (ProgressBar) findViewById(R.id.progressBarWeb);
        webView = (WebView) findViewById(R.id.webView);

        Intent intent = getIntent();
        Uri blogUri = intent.getData();

        webView.loadUrl(blogUri.toString());

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                //making progress bar disappear.
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}