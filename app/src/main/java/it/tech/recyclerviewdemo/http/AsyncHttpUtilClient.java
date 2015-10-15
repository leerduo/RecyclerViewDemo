package it.tech.recyclerviewdemo.http;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Created by chenfuduo on 2015/10/15.
 */
public class AsyncHttpUtilClient {
    private static AsyncHttpClient client = new AsyncHttpClient();
    public static void get(String url,RequestParams params,AsyncHttpResponseHandler handler){
        client.get(url,params,handler);
    }
}
