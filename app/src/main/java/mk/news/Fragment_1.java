package mk.news;

import android.app.ProgressDialog;
import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment_1 extends AppCompatActivity {

    WebView webView;
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_1);

        Toast.makeText(this,"Please wait",Toast.LENGTH_LONG).show();


        imageView=(ImageView) findViewById(R.id.BackButton);
        webView=(WebView) findViewById(R.id.webView);
        textView=(TextView) findViewById(R.id.Heading);
        //setContentView(webView);

        ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Loading...");

        progressDialog.show();

        String URL =getIntent().getStringExtra("newDescription");

        //String heading=getIntent().getStringExtra("News");

        //textView.setText(heading);

       // Log.d("WebView",URL);
        webView.setWebViewClient(new WebViewClient());

        progressDialog.dismiss();

        webView.loadUrl(URL);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoingBack();
            }


        });



    }

    private void GoingBack() {

        Intent i=new Intent(Fragment_1.this,MainActivity.class);
        startActivity(i);
    }
}
