package cawabanga.com.InstagramSearchEndpointAPI;

import android.content.Context;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vstechlab.easyfonts.EasyFonts;

import java.util.ArrayList;

/**
 * Created by croatan on 24.5.2016. UndabotInstagramProject.
 */

public class InstagramImageAdapter extends ArrayAdapter<InstagramImage>{
    public InstagramImageAdapter(Context context, ArrayList<InstagramImage> aImages){
        super(context, 0, aImages);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        InstagramImage image = getItem(position);

        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_item, null);
        }

        TextView tvUsername = (TextView) convertView.findViewById(R.id.tv_username);
        TextView tvCaption = (TextView) convertView.findViewById(R.id.tv_caption_text);
        ImageView ivPhotoContent = (ImageView) convertView.findViewById(R.id.iv_photo_content);

        TextView tvUsernameUp = (TextView) convertView.findViewById(R.id.tv_username_up);
        ImageView ivProfilePhoto = (ImageView) convertView.findViewById(R.id.iv_profile_image);
        TextView tvLocation = (TextView) convertView.findViewById(R.id.tv_location);
        TextView tvLikes = (TextView)convertView.findViewById(R.id.tv_likes_text);
        TextView tvCreatedTime = (TextView)convertView.findViewById(R.id.tv_time_created);
        CharSequence createdTime = DateUtils.getRelativeTimeSpanString(image.getImage_created_time()*1000, System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS, DateUtils.FORMAT_ABBREV_ALL);


        tvUsername.setTypeface(EasyFonts.robotoRegular(getContext()));
        tvCaption.setTypeface(EasyFonts.robotoThin(getContext()));
        tvLocation.setTypeface(EasyFonts.robotoThin(getContext()));
        tvLikes.setTypeface(EasyFonts.robotoRegular(getContext()));
        tvUsernameUp.setTypeface(EasyFonts.robotoRegular(getContext()));


        tvUsername.setText(image.getImage_owner());
        tvCaption.setText(image.getImage_title());
        tvLocation.setText(image.getImage_location());
        tvLikes.setText("Likes: "+image.getImage_likes());
        tvUsernameUp.setText(image.getImage_owner());
        tvCreatedTime.setText(createdTime);


        Picasso.with(getContext()).load(image.getImage_profile()).into(ivProfilePhoto);
        Picasso.with(getContext()).load(image.getImage_url()).into(ivPhotoContent);

        return convertView;
    }
}
