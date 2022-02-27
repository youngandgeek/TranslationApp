package com.example.translationapp;

/*word class to pass it to the ArrayList instead of arraylist of String (ArrayList<String>)
 it'll be ArrayList of word objects (ArrayList<Word>).

 */
public class Word {
 //two string values one for english and one for the translation(miwok) word and one int for the image
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    //constant value if its theres not an image associated with the word
    private  static final int noImageProvided = -1;
    //made the default value has no image
    private int imageResouceId=noImageProvided;
    //for the audio file
    private int audioResourceId;


    //constructor for phrasesActivity because it doesn't have an image
    public  Word(String defaultTranslation,String miwokTranslation,int audioId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        audioResourceId=audioId;

    }

//Constructor with three parameters for NumberActivity,colors and Family members
    public Word(String defaultTranslation,String miwokTranslation,int imgId,int audioId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        imageResouceId=imgId;
        audioResourceId=audioId;

    }

//two getter method to get the words and we don't have to set it
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }
    //getter for image Resource Id
    public int getImageResouceId(){
        return imageResouceId;
    }

    //boolean method to check whether if there's an image provided with that word or not
    public boolean hasImage(){

    return imageResouceId!=noImageProvided;
    }

    //getter method for the audio
    public int getAudioResource() {
        return audioResourceId;
    }
}
