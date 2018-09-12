package com.ebei.eba.common.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Map;

/**
 * Description:
 *
 * @author xu
 * @date:2018/5/29
 * @Copyright (c) 2018 一碑科技
 */
public class HttpRequestUtils {
    public static HttpURLConnection getUrlConnection(String url, int bufferSize) throws Exception{
        URL target = new URL(url);
        String BOUNDARY = "---------------------------123821742118716"; //boundary就是
        HttpURLConnection conn = (HttpURLConnection) target.openConnection();
        conn.setConnectTimeout(30000);
        conn.setReadTimeout(30000);
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setUseCaches(false);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("connection", "Keep-Alive");
//        conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
        conn.setChunkedStreamingMode(bufferSize);
        conn.setRequestProperty("Charsert", "UTF-8");
        conn.setRequestProperty("timenow", String.valueOf(System.currentTimeMillis()));
        conn.setRequestProperty("Content-Type", "multipart/form-data; boundary="+ BOUNDARY);

        return conn;
    }

    public static HttpResponse getHttpResponse(String url, Map<String, String> params) throws Exception{
        HttpParams httpParameters = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParameters, 2 * 60 * 100);
        HttpConnectionParams.setSoTimeout(httpParameters, 2 * 60 * 100);
        DefaultHttpClient client = new DefaultHttpClient(httpParameters);
        HttpGet httpGet = new HttpGet(new URI(url));
        for(Map.Entry<String, String> entry : params.entrySet()){
            httpGet.setHeader(entry.getKey(), entry.getValue());
        }
        return client.execute(httpGet);
    }

}
