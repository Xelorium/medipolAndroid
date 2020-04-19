package com.example.covidnineteen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity{

    String image_url = "https://coronavirus-monitor.p.rapidapi.com/coronavirus/random_masks_usage_instructions.php?rapidapi-key=81562325e2mshbd0d89553a475b7p15c935jsn5518849f9136";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new DownloadImage((ImageView) findViewById(R.id.sp_Art))
                .execute("https://coronavirus-monitor.p.rapidapi.com/coronavirus/random_masks_usage_instructions.php?rapidapi-key=81562325e2mshbd0d89553a475b7p15c935jsn5518849f9136");


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, totalInfectedActivity.class);
                startActivity(intent);
            }
        }, 4000);



    }

    private class DownloadImage extends AsyncTask<String, Void, Bitmap> {
        ImageView sp_Art;

        public DownloadImage(ImageView imageView) {
            this.sp_Art = imageView;
        }

        protected Bitmap doInBackground(String... urls) {
            String imageURL = urls[0];
            Bitmap bimage = null;
            try {
                InputStream in = new java.net.URL(imageURL).openStream();
                bimage = BitmapFactory.decodeStream(in);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return bimage;
        }

        protected void onPostExecute(Bitmap result) {
            sp_Art.setImageBitmap(result);
        }

}
}
