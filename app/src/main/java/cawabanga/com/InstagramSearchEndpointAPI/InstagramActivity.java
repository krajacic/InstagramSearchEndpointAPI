package cawabanga.com.InstagramSearchEndpointAPI;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * Created by croatan on 24.5.2016. UndabotInstagramProject.
 */
public class InstagramActivity extends AppCompatActivity {
    private ListView lvImages;
    private InstagramImageAdapter adapterImages;
    InstagramClient client;
    public static final String IMAGE_ZOOMED_KEY = "zoom";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvImages = (ListView) findViewById(R.id.lvImagessss);
        ArrayList<InstagramImage> aImages = new ArrayList<InstagramImage>();
        adapterImages = new InstagramImageAdapter(this, aImages);
        lvImages.setAdapter(adapterImages);

        fetchInstagramImages();
        setupImageSelectedListener();
    }

    private void fetchInstagramImages(){
        client = new InstagramClient();
        client.getInstagramImages(new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                JSONArray items = null;
                try {

                    items = response.getJSONArray("data");
                    ArrayList<InstagramImage> images = InstagramImage.fromJson(items);
                    adapterImages.addAll(images);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void setupImageSelectedListener() {
        lvImages.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(InstagramActivity.this, InstagramZoom.class);
                i.putExtra(IMAGE_ZOOMED_KEY, adapterImages.getItem(position));
                startActivity(i);
            }
        });
    }


}
