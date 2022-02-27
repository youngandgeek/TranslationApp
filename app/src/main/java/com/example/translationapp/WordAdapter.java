package com.example.translationapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

//for the background color of each category list
private int mColorResouceId;

//modify the constructor and add (pass) the color resource id
    public WordAdapter(Activity context, ArrayList<Word>words,int colorResourceId) {
        super(context,0, words);
    mColorResouceId=colorResourceId;
    }

        @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View listItemView = convertView;
            if (listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.list_item_layout, parent, false);

                        }
//itemPosition from Word class and store it in var: currentWord
            Word currentWord = getItem(position);


            // Find the TextView in the list_item.xml layout with the ID version_name
            TextView miwokTxtView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
            // Get the version name from the current AndroidFlavor object and
            // set this text on the name TextView
            miwokTxtView.setText(currentWord.getMiwokTranslation());

            // Find the TextView in the list_item.xml layout with the ID version_name
            TextView defaultTxtView = (TextView) listItemView.findViewById(R.id.trans_text_view);
            // Get the version name from the current AndroidFlavor object and
            // set this text on the name TextView(currentWord --> the item position).methodName from class
            defaultTxtView.setText(currentWord.getDefaultTranslation());


            ImageView imgView=(ImageView) listItemView.findViewById(R.id.word_img);
//check if theres an image or not .boolean method in word class
            if (currentWord.hasImage()) {
                imgView.setImageResource(currentWord.getImageResouceId());
                imgView.setVisibility(View.VISIBLE);
            }
            else{
                imgView.setVisibility(View.GONE);

            }
            // Set the theme color for the list item
            View textContainer = listItemView.findViewById(R.id.text_container);
            // Find the color that the resource ID maps to
            int color = ContextCompat.getColor(getContext(), mColorResouceId);
            textContainer.setBackgroundColor(color);


            // Return the whole list item layout (containing 2 TextViews and an ImageView)
            // so that it can be shown in the ListView
            return listItemView;


            /*  * AndroidFlavor currentAndroidFlavor = getItem(position);

            // Find the TextView in the list_item.xml layout with the ID version_name
            TextView nameTextView = (TextView) listItemView.findViewById(R.id.version_name);
            // Get the version name from the current AndroidFlavor object and
            // set this text on the name TextView
            nameTextView.setText(currentAndroidFlavor.getVersionName());

            // Find the TextView in the list_item.xml layout with the ID version_number
            TextView numberTextView = (TextView) listItemView.findViewById(R.id.version_number);
            // Get the version number from the current AndroidFlavor object and
            // set this text on the number TextView
            numberTextView.setText(currentAndroidFlavor.getVersionNumber());

            // Find the ImageView in the list_item.xml layout with the ID list_item_icon
            ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
            // Get the image resource ID from the current AndroidFlavor object and
            // set the image to iconView
            iconView.setImageResource(currentAndroidFlavor.getImageResourceId());

            // Return the whole list item layout (containing 2 TextViews and an ImageView)
            // so that it can be shown in the ListView
            return listItemView;
        */
        }

        }
