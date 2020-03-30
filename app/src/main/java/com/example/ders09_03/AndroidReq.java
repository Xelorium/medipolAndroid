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

public class AndroidReq extends BaseReq {

    AndroidReqListener listener;

    public interface AndroidReqListener{
        void onRequestDone(String result);
    }

    public AndroidReq(AndroidReqListener listener){ // oluştuurulduğu method
        this.listener = listener ;
    }

    @Override
    public String getReqUrl() {
        return "https://restcountries-v1.p.rapidapi.com/all?rapidapi-key=577e1f28d2msh8b2bf1fed9ebd7ep1df55fjsn5b55f896a62a";
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        listener.onRequestDone(result);
    }
}
