package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by jorky on 31.05.17.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    /** Resource ID for the background color for this list of words */
    private int mColorResourceId;

    private static final String LOG_TAG = WordAdapter.class.getSimpleName();

    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId){
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word word = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID default_text_view
        TextView defaultTranslationTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the default translation from the current object and
        // set this text on the default TextView
        defaultTranslationTextView.setText(word.getDefaultTranslation());

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view
        TextView miwokTranslationTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the miwok translation from the current object and
        // set this text on the miwok TextView
        miwokTranslationTextView.setText(word.getMiwokTranslation());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);

        if(word.hasImage()) {
            // set the image to iconView
            iconView.setImageResource(word.getImageResouceId());

            //Make shure the view is visible
            iconView.setVisibility(View.VISIBLE);
        }
        else{
           //or hide the ImageView (set visibility to GONE)
            iconView.setVisibility(View.GONE);
        }

//        Set the color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
//        Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
//        Set the background color of the text contaner view
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}

