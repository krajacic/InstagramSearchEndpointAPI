package cawabanga.com.InstagramSearchEndpointAPI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by croatan on 24.5.2016. UndabotInstagramProject.
 */
public class InstagramImage implements Serializable {
    private static final long serialVersionUID = -8959832007991513854L;
    private String image_url;
    private String image_title;
    private String image_owner;

    private String image_profile;
    private String image_location;
    private int image_likes;
    private Long image_created_time;

    public static InstagramImage fromJson(JSONObject jsonObject){
        InstagramImage im = new InstagramImage();
        try {
            im.image_title = jsonObject.getJSONObject("caption").getString("text");
            im.image_owner = jsonObject.getJSONObject("caption").getJSONObject("from").getString("username");
            im.image_url = jsonObject.getJSONObject("images").getJSONObject("standard_resolution").getString("url");
            im.image_profile = jsonObject.getJSONObject("caption").getJSONObject("from").getString("profile_picture");
            im.image_location = jsonObject.getJSONObject("location").getString("name");
            im.image_likes = jsonObject.getJSONObject("likes").getInt("count");
            im.image_created_time = jsonObject.getJSONObject("caption").getLong("created_time");


        }catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        return im;
    }


    public static ArrayList<InstagramImage> fromJson(JSONArray jsonArray){
        ArrayList<InstagramImage> images = new ArrayList<InstagramImage>(jsonArray.length());


        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject imageJson = null;
            try {
                imageJson = jsonArray.getJSONObject(i);
            }catch (Exception e){
                e.printStackTrace();
                continue;
            }

            InstagramImage image = InstagramImage.fromJson(imageJson);
            if (image != null){
                images.add(image);
            }
        }

        return images;
    }

    public String getImage_owner() {
        return image_owner;
    }

    public String getImage_title() {
        return image_title;
    }

    public String getImage_url() {
        return image_url;
    }

    public Long getImage_created_time() {
        return image_created_time;
    }

    public int getImage_likes() {
        return image_likes;
    }

    public String getImage_location() {
        return image_location;
    }

    public String getImage_profile() {
        return image_profile;
    }
}
