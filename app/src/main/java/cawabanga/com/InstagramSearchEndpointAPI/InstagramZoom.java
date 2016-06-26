package cawabanga.com.InstagramSearchEndpointAPI;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import uk.co.senab.photoview.PhotoView;

/**
 * Created by croatan on 24.5.2016. UndabotInstagramProject.
 */
public class InstagramZoom extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_zoomed);

        InstagramImage image = (InstagramImage)getIntent().getSerializableExtra(InstagramActivity.IMAGE_ZOOMED_KEY);
        loadImage(image);

    }

    private void loadImage(InstagramImage image) {
        PhotoView photoView = (PhotoView) findViewById(R.id.iv_photo);

        Picasso.with(this).load(image.getImage_url()).placeholder(R.drawable.placeholder).into(photoView);
    }
}
