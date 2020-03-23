package com.example.ders09_03;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;

import javax.net.ssl.HttpsURLConnection;

public class AndroidReq extends AsyncTask<Void,Void,Void> {

    AndroidReqListener listener;

    public interface AndroidReqListener{
        void onRequestDone(String result);
    }

    public AndroidReq(AndroidReqListener listener){ // oluştuurulduğu method
        this.listener = listener ;
    }

    String result = "";

    @Override
    protected Void doInBackground(Void... voids) {


        try {
            URL url = new URL ("https://restcountries-v1.p.rapidapi.com/all?rapidapi-key=577e1f28d2msh8b2bf1fed9ebd7ep1df55fjsn5b55f896a62a");

            HttpURLConnection connection =(HttpsURLConnection) url.openConnection(); // gönderieln url e bağlanmadsı açması için
            InputStream stream = connection.getInputStream(); //data akışını getir. açılan urlyi

            InputStreamReader reader = new InputStreamReader(stream);// akışı oku
            BufferedReader bfReader = new BufferedReader(reader); // bufferle adım adım sürekili olku  dataya çevir

            String res = "";
            while ((res = bfReader.readLine()) != null){
                result += res;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.d("MedipolRq:",result);

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        listener.onRequestDone(result);
    }
}
