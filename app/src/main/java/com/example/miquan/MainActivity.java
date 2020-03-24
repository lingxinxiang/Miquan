package com.example.miquan;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    //  String url = "https://suzhougs.pang118.com/api/device/queryDeviceSaleProducts?deviceId=1077 https://api.apiopen.top/getImages?page=0&count=10";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread() {
            @Override
            public void run() {
                requestData();
            }
        }.start();
    }

    private void requestData() {
        HttpURLConnection connection = null;
        try {
            URL url = new URL("https://suzhougs.pang118.com/api/device/queryDeviceSaleProducts?deviceId=1077");
            connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(3000);//连接超时
            connection.setReadTimeout(3000);//读取超时
            connection.setRequestMethod("GET");//设置请求方式
            connection.setDoInput(true);
            connection.setDoOutput(false);
            connection.connect();


            int responseCode = connection.getResponseCode();
            //判断HTTP是否等于200
            if (responseCode != HttpURLConnection.HTTP_OK) {
                throw new IOException("HTTP error code:" + responseCode);
            }

            String result = getStringByStream(connection.getInputStream());
            //判断结构是否为空
            if (result == null) {
                throw new IOException("读取流失败");
            }
            Log.d("TEST", "result" + result);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getStringByStream(InputStream inputStream) {
        Reader reader;
        try {
            reader = new InputStreamReader(inputStream, "UTF-8");
            char[] rawBuffer = new char[512];
            StringBuilder buffer = new StringBuilder();
            int length;
            while ((length = reader.read(rawBuffer)) != -1) {
                buffer.append(rawBuffer, 0, length);

            }
            return buffer.toString();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}