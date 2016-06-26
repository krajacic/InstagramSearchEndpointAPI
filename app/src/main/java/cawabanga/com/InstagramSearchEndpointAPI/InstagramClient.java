package cawabanga.com.InstagramSearchEndpointAPI;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

public class InstagramClient {
    private final String API_BASE_URL = "https://api.instagram.com/v1/media/search?access_token=";
    private AsyncHttpClient client;

    public InstagramClient(){
        this.client = new AsyncHttpClient();
    }


    public void getInstagramImages(JsonHttpResponseHandler handler) {
        String url = getApiUrl("1318098499.338efee.5fd6a8cc3b7d4374ad88c1f84f9e5f37&lat=46.5131&lng=16.4394&distance=5000"); //change this with your own lat, lng and access-token
        client.get(url, handler);
    }

    private String getApiUrl(String relativeUrl) {
        return API_BASE_URL + relativeUrl;
    }

}
