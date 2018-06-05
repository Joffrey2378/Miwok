package com.example.android.miwok;

import android.content.Context;
import android.content.Intent;

/**
 * Created by jorky on 29.05.17.
 */

public class Word {

    /** Default translation for the word*/
    private String mDefaultTranslation;

    /** Miwok translation for the word*/
    private String mMiwokTranslation;

    /** Image resource ID for the word*/
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    /** Sound resource ID for the word*/
    private int mAudioResourceId;

    /**
     *  Create a new word object.
     *
     *  @param defaultTranslation is the word in a language that thу user is alredy familiar with
     *                              (such as English)
     *  @param miwokTranslation is the word in the Miwok language
     *  @param audioResourceId is the audio resource ID for the audio associated with the word
     *
     */
    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;
    }

    /**
     *  Create a new word object.
     *
     *  @param defaultTranslation is the word in a language that thу user is alredy familiar with
     *                              (such as English)
     *  @param miwokTranslation is the word in the Miwok language
     *  @param imageResourceId is the drawable resource ID for the image associated with the word
     *  @param audioResourceId is the audio resource ID for the audio associated with the word
     *
     */
    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int audioResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    /**
     * Return the word in a default a language
     */
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    /**
     * Return the Miwok word
     */
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    /**
     * Return the image resource ID for the word
     */
    public Integer getImageResouceId() {
        return mImageResourceId;
    }

    /**
     * Returns wether or not there is an image for the word
     *
     */
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * Return the sound resource ID for the word
     */
    public Integer getAudioResourceId() {
        return mAudioResourceId;
    }
}
